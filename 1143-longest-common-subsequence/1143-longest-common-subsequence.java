// class Solution {
//     //tc=O(n*m) sc=O(n*m)
//     public int LCS(int i,int j,StringBuilder a, StringBuilder b,int dp[][]){
//         if(i<0 || j<0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(a.charAt(i)==b.charAt(j)){
//             return dp[i][j]=1+LCS(i-1,j-1,a,b,dp);
//         }
//         else{
//             return dp[i][j]=Math.max(LCS(i,j-1,a,b,dp),LCS(i-1,j,a,b,dp));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m=text1.length();
//         int n=text2.length();
//         StringBuilder a=new StringBuilder(text1);
//         StringBuilder b=new StringBuilder(text2);
//         //i=>0 to m-1 and j=>0 to n-1
//         int dp[][]=new int[m][n];
//         for(int rows[]:dp) Arrays.fill(rows,-1);
//         return LCS(m-1,n-1,a,b,dp);

//     }
// }

class Solution {
    //tabulation
    //tc=O(n*m) sc=O(n*m)
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m=text1.length();
    //     int n=text2.length();
    //     int dp[][]=new int[m+1][n+1];
    //     for(int i=1;i<=m;i++){
    //         for(int j=1;j<=n;j++){
    //             if(text1.charAt(i-1)==text2.charAt(j-1)){
    //                 dp[i][j]=1+dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        //tabulation space optimization
        //tc=O(m*(n+n))=>O(m*2n) sc=O(n)
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int[2][n+1];
        for(int i=1;i<=m;i++){ //m times

            for(int j=1;j<=n;j++){  //n times

                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[1][j]=1+dp[0][j-1];
                }
                else{
                    dp[1][j]=Math.max(dp[1][j-1],dp[0][j]);
                }
            }
            for(int k=0;k<=n;k++) dp[0][k]=dp[1][k]; //n times
        }
        return dp[1][n];
    }
}