// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();
        while(i<post_exp.length()){
            char ch=post_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String t1=st.pop();
                String t2=st.pop();
                st.push(ch+t2+t1);
            }
            i++;
        }
        return st.peek();
    }
}
