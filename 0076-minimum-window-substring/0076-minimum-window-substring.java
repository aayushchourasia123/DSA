class Solution {
    public String minWindow(String s, String t) {
        //tc=O(n+m) sc=O(256)
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int l=0,minlen=Integer.MAX_VALUE,cnt=0,sIdx=-1;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(mp.containsKey(ch) && mp.get(ch)>0){
                cnt++;
            }
            mp.put(ch,mp.getOrDefault(ch,0)-1);

            while(cnt==t.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sIdx=l;
                }
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)+1);
                if(mp.get(s.charAt(l))>0) cnt--;
                l++;
            }
        }
        return sIdx==-1?"":s.substring(sIdx,sIdx+minlen);
    }
}