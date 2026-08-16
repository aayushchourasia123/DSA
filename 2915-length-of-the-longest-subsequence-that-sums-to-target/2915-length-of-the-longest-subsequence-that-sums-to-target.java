class Solution {
    //tc+O(n*sum) sc=O(n*sum)
    public int findLength(int i,List<Integer> nums,int target,int sum,int dp[][]){
        if (sum > target)
        return Integer.MIN_VALUE;

        if(i==nums.size()){
            if(sum==target) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];

        int skip=findLength(i+1,nums,target,sum,dp);

        int pick=findLength(i+1,nums,target,sum+nums.get(i),dp);
        if(pick!=Integer.MIN_VALUE) {
            pick=1+pick;
        }
        
        return dp[i][sum]=Math.max(skip,pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        //i->0 to n-1 and sum=0 to target
        int dp[][]=new int[nums.size()][target+1];
        for(int row[] : dp) Arrays.fill(row,-1);

        int ans= findLength(0,nums,target,0,dp);
        if(ans==Integer.MIN_VALUE) return -1;
        return ans;
    }
}