class Solution {
    //tc=O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                return new int[]{mp.get(rem),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}