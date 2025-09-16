class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(l<=h){

            int mid=(l+h)/2;

            if(nums[l]<=nums[mid]){ //left sorted
                
                    ans=Math.min(ans,nums[l]);
                
                
                l=mid+1;
            }
            else {
                ans=Math.min(ans,nums[mid]);
                h=mid-1;
            }
            
        }

        return ans;
    }
}