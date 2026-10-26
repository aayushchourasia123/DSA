class Solution {
    int m,n,k;
    public long dfs(int grid[][],int r,int c){
        if(r<0 || r>=m || c<0 || c>=n) return 0;
        if(grid[r][c]==0) return 0;
        
        long val=grid[r][c];
        grid[r][c]=0;

        long total=val;

        total=(total+dfs(grid,r,c-1))%k;
        total=(total+dfs(grid,r,c+1))%k;
        total=(total+dfs(grid,r-1,c))%k;
        total=(total+dfs(grid,r+1,c))%k;

        return total;
    }
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        this.k=k;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    if(dfs(grid,i,j)==0) count++;
                }
            }
        }
        return count;
    }
}