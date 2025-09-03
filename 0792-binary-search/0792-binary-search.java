class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        //if(n==1 && nums[0]==target)

        int r=0,l=n-1;
        while(r<=l){
            int mid=(r+l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) l=mid-1;
            else r=mid+1;
        }
        return -1;
    }
}