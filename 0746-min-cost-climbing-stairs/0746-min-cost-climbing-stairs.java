class Solution {
    // public int minCost(int cost[],int n,int dp[]){
    //     //tc=O(n) sc=O(n) memoization
    //     if(n<0) return 0;
    //     if(n==0||n==1) return cost[n];
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=cost[n]+Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     //n is going from n-1/n-2 to 0
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,-1);
    //     return Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
    // }
    public int minCostClimbingStairs(int[] cost) {
        //tc=O(n) sc=O(n) tabulation
        int n=cost.length;
        int dp[]=new int[n];
        dp[0]=cost[0];dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}