class Solution {
    //tc=O(n) sc=O(n)
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(robed(nums,0,n-2),robed(nums,1,n-1));
    }
    public int robed(int nums[],int st,int end){
        int m=end-st+1;
        int dp[]=new int[m];
        dp[0]=nums[st];
        dp[1]=Math.max(nums[st],nums[st+1]);
        for(int i=2;i<m;i++){
            dp[i]=Math.max(nums[st+i]+dp[i-2],dp[i-1]);
        }
        return dp[m-1];
    }
}