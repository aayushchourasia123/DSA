class Solution {
    public void sortColors(int[] nums) {
        //dutch-nation algo
        int i=0; //0
        int j=0; //1
        int k=nums.length-1; //2
        while(j<=k){
            if(nums[j]==1) j++;
            else if(nums[j]==2){
                //swap nums[j],nums[k]
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                k--;
            }
            else{
                //nums[j]==0
                //swap(nums[i],nums[j])
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
        }
    }
}