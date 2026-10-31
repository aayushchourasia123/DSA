class Solution {
    public int minCost(int[][] grid) {
        //tc=O(m*n*1024)
        //sc=O(m*n*1024)
        int m=grid.length;
        int n=grid[0].length;

        BitSet dp[][]=new BitSet[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new BitSet(1024);
            }
        }
        dp[0][0].set(grid[0][0]);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;

                BitSet up=new BitSet(1024);
                BitSet left=new BitSet(1024);

                if(i>0){
                    up=(BitSet) dp[i-1][j].clone();
                }
                if(j>0){
                    left=(BitSet) dp[i][j-1].clone();
                }
                BitSet combine=(BitSet) up.clone();
                combine.or(left);

                for(int xorVal=0;xorVal<1024;xorVal++){
                    if(combine.get(xorVal)){
                        int resXor=grid[i][j]^xorVal;
                        dp[i][j].set(resXor);
                    }
                }
            }
        }

        //dp[m-1][n-1]
        for(int xorVal=0;xorVal<1024;xorVal++){
            if(dp[m-1][n-1].get(xorVal)){
                return xorVal;
            }
        }
        return -1;
    }
}