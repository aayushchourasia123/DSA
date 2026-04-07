class Solution {
    public int totalFruit(int[] fruits) {
        //tc=O(n) sc=O(1)
        int l=0,r=0,maxlen=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(r<fruits.length){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);

            if(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            if(mp.size()<=2){
                maxlen=Math.max(r-l+1,maxlen);
            }
            r++;
        }
        return maxlen;
    }
}