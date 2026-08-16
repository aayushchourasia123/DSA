// class Solution {
//     //tc=O(n*c) sc=O(n*c)
//     public int helper(int i,int val[],int wt[],int c,int dp[][]){
//         if(i<0) return 0;
        
//         if(dp[i][c]!=-1) return dp[i][c];
//         int skip=helper(i-1,val,wt,c,dp);
//         if(wt[i]>c) return dp[i][c]=skip;
        
//         int pick=val[i]+helper(i-1,val,wt,c-wt[i],dp);
//         return dp[i][c]=Math.max(pick,skip);
//     }
//     public int knapsack(int W, int val[], int wt[]) {
//         // code here
//         int n=val.length;
//         int dp[][]=new int[n][W+1];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         return helper(n-1,val,wt,W,dp);
//     }
// }

class Solution {
    //tabulation
    //tc=O(n*c) sc=O(n*c)
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int dp[][]=new int[n][W+1];
        
        for(int i=0;i<n;i++){
            for(int c=0;c<W+1;c++){
                int skip=(i>0)? dp[i-1][c]:0;
                if(wt[i]>c) dp[i][c]=skip;
                else{
                    int pick=val[i];
                    pick+=(i>0)? dp[i-1][c-wt[i]]:0;
                    dp[i][c]=Math.max(pick,skip);
                }
            }
        }
        return dp[n-1][W];
    }
}
