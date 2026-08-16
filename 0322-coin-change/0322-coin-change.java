// class Solution {
//     //tc=O(n*amt) sc=O(n*amt)
//     public long coinCount(int i,int amt,int coins[],long dp[][]){
//         if(i<0){
//             if(amt==0) return 0;
//             else return Integer.MAX_VALUE; // not a valid combinations
//         }
//         if(dp[i][amt]!=-1) return dp[i][amt];

//         long skip=coinCount(i-1,amt,coins,dp);

//         if(amt-coins[i]<0) return dp[i][amt]=skip;

//         long pick=1+coinCount(i,amt-coins[i],coins,dp);
        
//         return dp[i][amt]=Math.min(pick,skip);
//     }
//     public int coinChange(int[] coins, int amount) {
//         //i=>n-1 to 0 and amt=>amt to 0
//         int n=coins.length;
//         long dp[][]=new long[coins.length][amount+1];
//         for(long row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         int ans= (int)coinCount(n-1,amount,coins,dp);
//         if(ans==Integer.MAX_VALUE) return -1;
//         return ans;
//     }
// }

class Solution {
    //tabulations
    //tc=O(n*amt) sc=O(n*amt)
    public int coinChange(int[] coins, int amount) {
        //i=>n-1 to 0 and amt=>amt to 0
        int n=coins.length;
        long dp[][]=new long[coins.length][amount+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                long skip=(i>0)? dp[i-1][j] : (j==0)? 0:Integer.MAX_VALUE;
                if(j-coins[i]<0) dp[i][j]=skip;
                else{
                    long pick=1+dp[i][j-coins[i]];
                    dp[i][j]=Math.min(pick,skip);
                }
            }
        }

        int ans= (int)dp[n-1][amount];
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}