class Solution {
    public int lengthOfLongestSubstring(String s) {
        //tc=O(n) sc=O(256)
        int hash[]=new int[256];
        Arrays.fill(hash,-1);
        int l=0,r=0,maxlen=0;
        int n=s.length();
        while(r<n){
            char ch=s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l=hash[ch]+1;
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxlen;
    }
}