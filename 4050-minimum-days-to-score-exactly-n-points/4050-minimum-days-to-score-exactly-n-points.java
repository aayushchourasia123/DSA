class Solution {
    public int solve(int n,int dp[]){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int x=i*(i+1)/2;
            if(x>n) break;
            int rem=n-x;
            if(rem==0) ans=Math.min(ans,i);
            else{
                ans=Math.min(ans,i+1+solve(rem,dp));
            }
        }
        return dp[n]=ans;
    }
    public int minDays(int n) {
        int dp[]=new int [n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}