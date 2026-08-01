class Solution {
    // public int amt(int nums[],int i,int dp[]){
    //     if(i>=nums.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int take=nums[i]+amt(nums,i+2,dp);
    //     int skip=amt(nums,i+1,dp);
    //     return dp[i]=Math.max(take,skip);
    // }
    // public int rob(int[] nums) {
    //     int dp[]=new int[nums.length]; //i varies from 0 to n-1
    //     Arrays.fill(dp,-1);
    //     return amt(nums,0,dp);
    // }

    //tabulation tc=O(n) sc=O(n)
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}