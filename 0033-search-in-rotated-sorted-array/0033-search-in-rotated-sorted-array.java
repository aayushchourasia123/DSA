class Solution {
    public int search(int[] nums, int target) {
       int l=0,h=nums.length-1;

       while(l<=h){
        int mid=(l+h)/2;

        if(nums[mid]==target) return mid;

        if(nums[l]<=nums[mid]){//left half sorted
            if(nums[l]<=target && target<=nums[mid]){ //if lies target lies in left half
                h=mid-1;
            }
            else l=mid+1;
        } 
        if(nums[mid]<=nums[h]){//right half sorted
            if(nums[mid]<=target && target<=nums[h]){ //if lies target lies in right half
                l=mid+1;
            }
            else h=mid-1;
        }
       }
       return -1;

    }
}