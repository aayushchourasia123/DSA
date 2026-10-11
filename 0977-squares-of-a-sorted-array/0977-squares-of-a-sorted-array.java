class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        int res[]=new int[n];
        int l=0,h=n-1;
        for(int j=n-1;j>=0;j--){
            if(nums[h]>nums[l]){
                res[j]=nums[h];
                h--;
            }
            else {
                res[j]=nums[l];
                l++;
            }
        }
        return res;
    }
}