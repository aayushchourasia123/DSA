class Solution {
    //tc=O(n*amt) sc=O(n*amt)
    public long coinCount(int i,int amt,int coins[],long dp[][]){
        if(i==coins.length){
            if(amt==0) return 0;
            else return Integer.MAX_VALUE; // not a valid combinations
        }
        if(dp[i][amt]!=-1) return dp[i][amt];

        long skip=coinCount(i+1,amt,coins,dp);

        if(amt-coins[i]<0) return dp[i][amt]=skip;

        long pick=1+coinCount(i,amt-coins[i],coins,dp);
        
        return dp[i][amt]=Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        long dp[][]=new long[coins.length][amount+1];
        for(long row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans= (int)coinCount(0,amount,coins,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}