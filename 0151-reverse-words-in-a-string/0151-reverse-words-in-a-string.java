class Solution {
    public String reverseWords(String s) {
        StringBuilder st=new StringBuilder();
        s=s.trim();
        int start=s.length();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            
            if(ch==' '){
                st.append(s.substring(i+1,start));
                if(i+1!=start){
                st.append(' ');
                }
                start=i;
            }
            if(i==0){
                st.append(s.substring(i,start));
            }
        }
        return st.toString();
    }
}