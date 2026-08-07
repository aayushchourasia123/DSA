class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //tc=O(m*n) sc=O(1)
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        
        obstacleGrid[0][0] = 1;

        boolean obs1=false,obs2=false;
        for(int i=1;i<n;i++){
            if(!obs1 && obstacleGrid[0][i]==0) obstacleGrid[0][i]=1;
            else if(obstacleGrid[0][i]==1){
                    obstacleGrid[0][i]=-1;
                    obs1=true;
                }
            else if(obs1 && obstacleGrid[0][i]==0){
                obstacleGrid[0][i]=-1;
            }
        }
        if(obstacleGrid[m-1][n-1]==-1) return 0;
        for(int i=1;i<m;i++){
            if(!obs2 && obstacleGrid[i][0]==0) obstacleGrid[i][0]=1;
            else if(obstacleGrid[i][0]==1){
                    obstacleGrid[i][0]=-1;
                    obs2=true;
            }
            else if(obs2 && obstacleGrid[i][0]==0){
                obstacleGrid[i][0]=-1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) obstacleGrid[i][j]=-1;
                else if(obstacleGrid[i][j]==0){
                    if(obstacleGrid[i][j-1]!=-1) obstacleGrid[i][j]+=obstacleGrid[i][j-1];
                    if(obstacleGrid[i-1][j]!=-1) obstacleGrid[i][j]+=obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}