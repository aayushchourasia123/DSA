class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int smp=1;
        for(int x:nums){
            if(x>0) hs.add(x);
        }
        while(hs.contains(smp)){
            smp++;
        }
        return smp;
    }
}