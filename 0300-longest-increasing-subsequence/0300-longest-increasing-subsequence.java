class Solution {
    public int lengthOfLIS(int[] nums) {
        //tc=O(n^2) sc=O(n)
        int n=nums.length;
       int dp[]=new int[n];
       int max=0;
       for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]);
            }
            dp[i]+=1;
            max=Math.max(max,dp[i]);
       }
       return max;
    }
}