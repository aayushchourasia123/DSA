class Solution {
    public int amt(int nums[],int i,int dp[]){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int take=nums[i]+amt(nums,i+2,dp);
        int skip=amt(nums,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length]; //i varies from 0 to n-1
        Arrays.fill(dp,-1);
        return amt(nums,0,dp);
    }
}