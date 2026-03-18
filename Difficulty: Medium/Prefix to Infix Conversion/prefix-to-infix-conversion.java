// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int i=pre_exp.length()-1;
        Stack<String> st=new Stack<>();
        while(i>=0){
            char ch=pre_exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                String con='('+t1+ch+t2+')';
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
}
