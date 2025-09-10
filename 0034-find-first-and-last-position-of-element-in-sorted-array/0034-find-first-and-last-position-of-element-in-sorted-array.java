class Solution {
    public int[] searchRange(int[] nums, int target) {
       
       int first=findBound(nums,target,true);
       int last=findBound(nums,target,false);

        return new int[]{first,last};
    }

    public int findBound(int nums[],int target,boolean isFirst){
        int low=0,high=nums.length-1;
        int bound=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(nums[mid]==target){
                bound=mid;
                if(isFirst){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return bound;
    }
}