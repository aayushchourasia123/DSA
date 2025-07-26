class Solution {
    //tc=O(3n)
    //sc=O(1)
    public void nextPermutation(int[] nums) {
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
             reverse(nums,0,nums.length-1);
             return;
        }

        for(int i=nums.length-1;i>=idx;i--){
            if(nums[idx]<nums[i]){
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        reverse(nums,idx+1,nums.length-1);
        
    }
    void reverse(int nums[],int st,int ed)
    {
        
        while(st<ed){
            int temp=nums[st];
            nums[st]=nums[ed];
            nums[ed]=temp;
            st++;
            ed--;
        }
    }
}