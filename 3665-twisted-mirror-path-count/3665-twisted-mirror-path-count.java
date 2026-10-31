// class Solution {
//     //tc=O(m*n*(m+n))
//     //sc=O(m*n)
//     int m;
//     int n;
//     int grid[][];
//     int dp[][];
//     public int enter(int row,int col,int dr,int dc){

//         while(row<m && col<n){
//             if(row==m-1 && col==n-1) return row*n+col;
//             if(grid[row][col]==0) return row*n+col;

//             if(dr==0){
//                 //entered while moving right-> turn down
//                 row++;
//                 dr=1;
//                 dc=0;
//             }
//             else{
//                 //entered while moving down-> turn right
//                 col++;
//                 dr=0;
//                 dc=1;
//             }
//         }
//         return -1;
//     }

//     public int path(int row,int col){
//         if(row>=m || col>=n) return 0;
//         if(row==m-1 && col==n-1) return 1;
//         if (dp[row][col] != -1) {
//             return dp[row][col];
//         }

//         int rightWay=0;
//         int downWay=0;
        
//         int rightNext=enter(row,col+1,0,1);
//         int downNext=enter(row+1,col,1,0);

//         if(rightNext!=-1){
//             rightWay=path(rightNext/n,rightNext%n);
//         }
//         if(downNext!=-1){
//             downWay=path(downNext/n,downNext%n);
//         }

//         return dp[row][col]=(rightWay+downWay)%(1000000007);

//     }
//     public int uniquePaths(int[][] grid) {
//         this.grid=grid;
//         m=grid.length;
//         n=grid[0].length;
//         dp=new int[m][n];
//         for(int row[]:dp) Arrays.fill(row,-1);
//         return path(0,0);
//     }
// }

//tabulations
class Solution {
    //tc=O(m*n*(m+n))
    //sc=O(m*n)
    int m;
    int n;
    int grid[][];
    public int enter(int row,int col,int dr,int dc){
        while(row<m && col<n){
            if(row==m-1 && col==n-1) return row*n+col;
            if(grid[row][col]==0) return row*n+col;

            if(dr==0){
                //entered while moving right-> turn down
                row++;
                dr=1;
                dc=0;
            }
            else{
                //entered while moving down-> turn right
                col++;
                dr=0;
                dc=1;
            }
        }
        return -1;
    }

    public int uniquePaths(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        int [][]dp=new int[m][n];
        dp[m-1][n-1]=1;

        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){

                if(row==m-1 && col==n-1) continue;
                
                int rightWay=0;
                int downWay=0;
                int rightNext=enter(row,col+1,0,1);
                int downNext=enter(row+1,col,1,0);

                if(rightNext!=-1){
                    rightWay=dp[rightNext/n][rightNext%n];
                }
                if(downNext!=-1){
                    downWay=dp[downNext/n][downNext%n];
                }
                dp[row][col]=(int)(((long)rightWay+downWay)%1000000007);
            }
        }
        return dp[0][0];
    }
}