class Solution {
    //tc=O(n*m) sc=O(n*m)
    public int Lcs(int i,int j,StringBuilder a,StringBuilder b,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=1+Lcs(i-1,j-1,a,b,dp);
        }
        else return dp[i][j]=Math.max(Lcs(i,j-1,a,b,dp),Lcs(i-1,j,a,b,dp));
    }
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder a=new StringBuilder(s);
        StringBuilder b=new StringBuilder(s).reverse();
        int dp[][]=new int[n][n];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return n-Lcs(n-1,n-1,a,b,dp);
    }
}