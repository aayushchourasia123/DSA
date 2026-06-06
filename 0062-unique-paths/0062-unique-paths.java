// class Solution {
//     public int func(int i,int j,int dp[][]){
//         if(i==0 && j==0) return 1;
//         if(i<0 || j<0) return 0;

//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int up=func(i-1,j,dp);
//         int left=func(i,j-1,dp);
//         dp[i][j]=up+left;
//         return up+left;
//     }
//     public int uniquePaths(int m, int n) {
//         //tc=O(2^m*n) sc=O(m-1 + n-1)
//         int dp[][]=new int[m][n];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         return func(m-1,n-1,dp);
//     }
// }

// class Solution {
//     //tabulation bottom up
//     public int uniquePaths(int m, int n) {
//         //tc=O(m*n) sc=O(m*n)
//         int dp[][]=new int[m][n];
//         dp[0][0]=1;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 && j==0) continue;
//                 else{
//                     int up=0,left=0;
//                     if(i>0)  up=dp[i-1][j];
//                     if(j>0)  left=dp[i][j-1];
//                     dp[i][j]=up+left;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

class Solution {
    //space optimization
    public int uniquePaths(int m, int n) {
        //tc=O(n*m) sc=O(n)
        int dp[]=new int[n];
        for(int i=0;i<m;i++){
            int temp[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                    int up=(i>0)? dp[j]:0;
                    int left=(j>0)? temp[j-1]:0;

                    temp[j]=up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}