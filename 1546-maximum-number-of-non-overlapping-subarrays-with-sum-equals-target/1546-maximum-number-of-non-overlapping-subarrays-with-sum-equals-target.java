class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        int count=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        int end=-1;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(mp.containsKey(sum-target) && mp.get(sum-target)>=end){
                count++;
                end=i;
            }
            mp.put(sum,i);
        }
        return count;
    }
}