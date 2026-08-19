// class Solution {
//     //tc=O(n*m) sc=O(n*m)
//     public int minStep(int i,int j,StringBuilder a,StringBuilder b,int dp[][]){
//         if(i==-1) return j+1;
//         if(j==-1) return i+1;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(a.charAt(i)==b.charAt(j)){
//             return dp[i][j]=minStep(i-1,j-1,a,b,dp);
//         }
//         else{
//             int del=minStep(i-1,j,a,b,dp);
//             int ins=minStep(i,j-1,a,b,dp);
//             int rep=minStep(i-1,j-1,a,b,dp);
//             return dp[i][j]=1+Math.min(del,Math.min(ins,rep));
//         }
//     }
//     public int minDistance(String word1, String word2) {
//         int m=word1.length();
//         int n=word2.length();
//         StringBuilder a=new StringBuilder(word1);
//         StringBuilder b=new StringBuilder(word2);
//         int dp[][]=new int[m][n];
//         for(int rows[]:dp) Arrays.fill(rows,-1);
//         return minStep(m-1,n-1,a,b,dp);
//     }
// }
class Solution {
    //tc=O(n*m) sc=O(n*m)
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        if(m==0 && n!=0) return n;
        if(m!=0 && n==0) return m;
        if(n==0 && m==0) return 0;
        
        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(word1.charAt(i)==word2.charAt(j)){
                    if(i-1==-1)  dp[i][j]=j+1;
                    else if(j-1==-1) dp[i][j]=i+1;
                    else dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int del=(i-1==-1)?j+1:dp[i-1][j];
                    int ins=(j-1==-1)?i+1:dp[i][j-1];
                    int rep;
                    if(i-1==-1)  rep=j+1;
                    else if(j-1==-1) rep=i+1;
                    else rep=dp[i-1][j-1];

                    dp[i][j]=1+Math.min(del,Math.min(ins,rep));
                }
            }
        }
        return dp[m-1][n-1]-1;
    }
}