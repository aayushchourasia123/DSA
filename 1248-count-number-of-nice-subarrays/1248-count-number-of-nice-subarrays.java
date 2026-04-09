class Solution {
    public static int findSub(int nums[],int goal){
        if(goal<0) return 0;
        int l=0,r=0,cnt=0,sum=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>goal){
                sum-=nums[l]%2;
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        //simialar to question 930
        return findSub(nums,k)-findSub(nums,k-1);
    }
}