class Solution {
    //tc=O(n*2) sc=O(n*2)
    public boolean isOdd(int n){
        return (n&1)==1;
    }
    public long score(int i,int nums[],int x,boolean prevParity,long dp[][]){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prevParity?0:1]!=-1) return dp[i][prevParity?0:1];
        long skip=score(i+1,nums,x,prevParity,dp);
        boolean currParity=isOdd(nums[i]);
        long pick=nums[i]+score(i+1,nums,x,currParity,dp)-(currParity==prevParity ? 0:x);
        return dp[i][prevParity?0:1]=Math.max(skip,pick);

    }
    public long maxScore(int[] nums, int x) {
        //i->0 to n and parity -> odd/even (1,0)
        long dp[][]=new long[nums.length][2];
        for(long rows[]:dp) Arrays.fill(rows,-1);
        return nums[0]+score(1,nums,x,isOdd(nums[0]),dp);
    }
}