class Solution {
    public String longestPalindrome(String s) {
        //tc=O(n^2) sc=O(n^2)
        int n=s.length();
        int max=-1,iM=-1,jM=-1;
        int dp[][]=new int[n][n];
        for(int k=0;k<n;k++){
            int i=0,j=k;
            while(j<n){
                if(i==j){
                    dp[i][j]=1;
                    if(j-i+1>max){
                        max=j-i+1;
                        iM=i;jM=j;
                    }
                }
                else if(j==i+1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=1;
                        if(j-i+1>max){
                            max=j-i+1;
                            iM=i;jM=j;
                        }
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]==1){
                            dp[i][j]=1;
                            if(j-i+1>max){
                                max=j-i+1;
                                iM=i;jM=j;
                            }
                        }
                    }
                }
                i++;j++;
            }
        }
        return s.substring(iM,jM+1);
    }
}