// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        //StringBuilder sb=new StringBuilder();
        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String s1=st.pop();
                String s2=st.pop();
                String ex='('+s2+ch+s1+')';
                st.push(ex);
            }
        }
        return st.peek();
    }
}
