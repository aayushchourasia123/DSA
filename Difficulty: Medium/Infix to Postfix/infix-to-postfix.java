class Solution {
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='-' || ch=='+') return 1;
        else return -1;
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch>='A' && ch<='Z' || ch>='a' && ch<='z' || ch>='0' && ch<='9'){
                sb.append(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();//pop out (
            }
            else{
                while(!st.isEmpty() && 
                     (priority(ch) < priority(st.peek()) ||
                     (priority(ch) == priority(st.peek()) && ch != '^'))){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
       return sb.toString(); 
    }
}