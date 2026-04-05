class Solution {
    //tc=O(n) sc=O(256)
    public int lengthOfLongestSubstring(String s) {
        int r=0,l=0,maxlen=0;
        int hash[]=new int[256];
        Arrays.fill(hash,-1);
        while(r<s.length()){
            char ch=s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l=hash[ch]+1;
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            hash[ch]=r;
            r++;
        }
        return maxlen;
    }
}