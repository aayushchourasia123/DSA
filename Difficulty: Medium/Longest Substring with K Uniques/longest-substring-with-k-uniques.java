class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        //tc=O(n)+O(log 26) hash map put complexity
        //sc=O(1)
        Map<Character,Integer> mpp=new HashMap<>();
        int l=0,maxlen=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            
            if(mpp.size()>k){
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);
                if(mpp.get(s.charAt(l))==0) mpp.remove(s.charAt(l));
                l++;
            }
            if(mpp.size()==k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            
        }
        return maxlen==0? -1:maxlen;
    }
}