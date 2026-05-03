class Solution {
    public boolean canJump(int[] nums) {
        //tc=O(n) sc=O(1)
        int maxIdx=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIdx) return false;
            maxIdx=Math.max(maxIdx,i+nums[i]);
            if(maxIdx>=nums.length) return true;
        }
        return true;
    }
}