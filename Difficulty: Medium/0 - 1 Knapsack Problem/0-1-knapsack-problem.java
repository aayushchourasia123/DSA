class Solution {
    //tc=O(n*c) sc=O(n*c)
    public int helper(int i,int val[],int wt[],int c,int dp[][]){
        if(i==wt.length) return 0;
        
        if(dp[i][c]!=-1) return dp[i][c];
        int skip=helper(i+1,val,wt,c,dp);
        if(wt[i]>c) return dp[i][c]=skip;
        
        int pick=val[i]+helper(i+1,val,wt,c-wt[i],dp);
        return dp[i][c]=Math.max(pick,skip);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int dp[][]=new int[n][W+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,val,wt,W,dp);
    }
}
