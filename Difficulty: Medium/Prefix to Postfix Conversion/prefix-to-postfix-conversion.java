// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        int i=pre_exp.length()-1;
        Stack<String> st=new Stack<>();
        while(i>=0){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) st.push(String.valueOf(ch));
            else{
                String t1=st.pop();
                String t2=st.pop();
                st.push(t1+t2+ch);
            }
            i--;
        }
        return st.peek();
    }
}
