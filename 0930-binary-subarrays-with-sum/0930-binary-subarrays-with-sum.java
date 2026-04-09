class Solution {
    public int findSub(int nums[],int goal){
        //tc=O(2n) //sc=O(1)
        if(goal<0) return 0;
        int l=0,r=0,sum=0,cnt=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        //no of subarray<=goal -no of subarray<=goal-1
        
        return findSub(nums,goal)-findSub(nums,goal-1);
    }
}