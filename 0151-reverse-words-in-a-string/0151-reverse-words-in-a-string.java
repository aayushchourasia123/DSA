class Solution {
    public String reverseWords(String s) {
        //TC=O(n)
        //SC=O(n)
        StringBuilder st=new StringBuilder();
        s=s.trim(); // remove leading and trailing spaces //TC(n)
        int start=s.length();
        for(int i=s.length()-1;i>=0;i--){ //TC(n)
            char ch=s.charAt(i);
            
            if(ch==' '){
                st.append(s.substring(i+1,start));//O(k) where k is length of the substring
                if(i+1!=start){
                st.append(' '); //TC(N)
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