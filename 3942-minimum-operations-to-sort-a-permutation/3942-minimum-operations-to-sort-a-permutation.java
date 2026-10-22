class Solution {
    public int minOperations(int[] nums) {
        int asc_cnt=0;
        int dsc_cnt=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==(nums[i-1]+1)%n){
                asc_cnt++;
            }
            if(nums[i-1]==(nums[i]+1)%n){
                dsc_cnt++;
            }
        }
        if(asc_cnt==n-1 && nums[0]==0) return 0;
        
        if(asc_cnt==n-1){
            int leftRotate=n-nums[0];
            int rightRotate=nums[n-1]+1+2;
            return Math.min(leftRotate,rightRotate);
        }
        if(dsc_cnt==n-1){
            int leftRotate=1+(n-nums[n-1]);//reverse + left rotate
            int rightRotate=(nums[0]+1)%n +1;
            return Math.min(leftRotate,rightRotate);
        }
        return -1;
    }
}