// class Solution {
        //tc=O(n^3)
//     static int cost(int i,int j,int arr[],int dp[][]){
//         if(i==j) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         int minCost=Integer.MAX_VALUE;
//         for(int k=i;k<j;k++){
//             int x=arr[i]*arr[k+1]*arr[j+1];
//             int totalCost=cost(i,k,arr,dp)+cost(k+1,j,arr,dp)+x;
//             minCost=Math.min(totalCost,minCost);
//         }
//         return dp[i][j]=minCost;
//     }
//     static int matrixMultiplication(int arr[]) {
//         // code here
//         int n=arr.length;
//         int i=0,j=n-2;
//         int dp[][]=new int[n-1][n-1];
//         for(int row[]:dp) Arrays.fill(row,-1);
//         return cost(i,j,arr,dp);
//     }
// }
class Solution {
    //tabulation
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int dp[][]=new int[n-1][n-1];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=n-2;j++){
                if(i>=j){
                    dp[i][j]=0;
                    continue;
                } 
                
                int minCost=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int x=arr[i]*arr[k+1]*arr[j+1];
                    int total=dp[i][k]+dp[k+1][j]+x;
                    minCost=Math.min(minCost,total);
                }
                dp[i][j]=minCost;
            }
        }
        return dp[0][n-2];
    }
}
