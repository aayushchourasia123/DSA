// class Solution {
//     //tc=O(m*n) sc=O(m*n)
//     public int minSum(int[][] grid,int i,int j,int m,int n,int dp[][]){
//         if(i>=m || j>=n) return Integer.MAX_VALUE;;
//         if(i==m-1 && j==n-1) return grid[i][j];
//         if(dp[i][j]!=-1) return dp[i][j];

//         int right = minSum(grid, i, j+1, m, n,dp);
//         int down = minSum(grid, i+1, j, m, n,dp);

//         int ans = Math.min(right, down);
//         if(ans == Integer.MAX_VALUE)
//             return dp[i][j]=ans;

//         return dp[i][j]=grid[i][j] + Math.min(right, down);
//     }
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int dp[][]=new int[m][n];
//         for(int row[]:dp){
//             Arrays.fill(row,-1);
//         }
//         return minSum(grid,0,0,m,n,dp);
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        //tc=O(m*n) sc=O(1)
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                else if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];
                else grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}