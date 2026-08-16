class Solution {
    //tc=O(n*target) sc=O(n*target)
    public boolean subset(int i,int target,int nums[],int dp[][]){
        if(i<0){
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean ans=false;
        boolean skip=subset(i-1,target,nums,dp);
        if(target-nums[i]<0){
            ans=skip;
        }
        else {
            boolean pick=subset(i-1,target-nums[i],nums,dp);
            ans= pick || skip;
        }
        dp[i][target]=(ans)?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        int target=sum/2;
        //i=n-1 to 0 and target=target to 0;
        int dp[][]=new int[n][target+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return subset(n-1,target,nums,dp);
    }
}