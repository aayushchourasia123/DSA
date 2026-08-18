class Solution {
    //tc=O(n*m) sc=O(n*m)
    public int Lcs(int i,int j,String a,String b,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=1+Lcs(i-1,j-1,a,b,dp);
        }
        else return dp[i][j]=Math.max(Lcs(i,j-1,a,b,dp),Lcs(i-1,j,a,b,dp));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m][n];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return n+m-2*Lcs(m-1,n-1,word1,word2,dp);
    }
}