class Solution {
    public String getSmallestString(String s, int k) {
        if(k==0) return s;
        String ans="";
        int n=s.length();
        for(int i=0;i<n;i++){
            int back=s.charAt(i)-'a';
            int forward='z'-s.charAt(i)+1;
            int min=Math.min(back,forward);
            if(k>=min){
                ans+='a';
                k-=min;
            }
            else{
                char ch=(char)(s.charAt(i)-k);
                ans+=ch;
                k=0;
            }
        }
        return ans;
    }
}