class Solution {
    public int longestOnes(int[] nums, int k) {
        
        if(k==0){
            int maxlen=0;
            int count=0;
            for(int i:nums){
                if(i==1){
                    count++;
                    maxlen=Math.max(maxlen,count);
                }
                else count=0;
            }
            return maxlen;
        }
        boolean mark_0[]=new boolean[nums.length];
        int l=0,r=0;
        int maxlen=0;
        while(r<nums.length){
            if(nums[r]==0&&k!=0){
                mark_0[r]=true;
                k--;
            }
            else if(nums[r]==0&&k==0){
                
                while(!mark_0[l]&&l<=r){
                    l++;
                }
                if(mark_0[l]==true){
                    mark_0[l]=false;
                    l++;
                    k++;
                    if(nums[r]==0&&k!=0){
                        mark_0[r]=true;
                        k--;
                    }
                }
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}