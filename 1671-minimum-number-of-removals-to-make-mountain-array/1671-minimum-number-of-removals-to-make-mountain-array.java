class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //tc=O(n^2) sc=O(n)
        int n=nums.length;
        int dp1[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[i]>nums[j]) dp1[i]=Math.max(dp1[i],dp1[j]);
            }
            dp1[i]+=1;
        }
        int dp2[]=new int[n];
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n-1;j++){
                if(nums[i]>nums[j]) dp2[i]=Math.max(dp2[i],dp2[j]);
            }
            dp2[i]+=1;
        }
        int maxLen=0;
        for(int i=1;i<n;i++){ //first element never be peak
            if(dp1[i]>1 && dp2[i]>1){ //So the peak must have at least one element on both sides
                int len=dp1[i]+dp2[i]-1;
                maxLen=Math.max(len,maxLen);
            }
        }
        if(maxLen<3) return 0;
        return n-maxLen;
    }
}