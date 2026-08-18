class Solution {
    //tc=O(n*m) sc=O(n*m)
    public int LCS(int i,int j,StringBuilder a, StringBuilder b,int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=1+LCS(i-1,j-1,a,b,dp);
        }
        else{
            return dp[i][j]=Math.max(LCS(i,j-1,a,b,dp),LCS(i-1,j,a,b,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        StringBuilder a=new StringBuilder(text1);
        StringBuilder b=new StringBuilder(text2);
        //i=>0 to m-1 and j=>0 to n-1
        int dp[][]=new int[m][n];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return LCS(m-1,n-1,a,b,dp);

    }
}