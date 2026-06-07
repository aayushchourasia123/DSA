class Solution {
    public int[] twoSum(int[] nums, int target) {
        //tc=O(n) sc=O(n)
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                return new int[]{mp.get(rem),i};
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}