class Solution {
    public static int func(int nums[],int k){
        Map<Integer,Integer> mpp=new HashMap<>();
        int l=0,count=0;
        for(int r=0;r<nums.length;r++){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);

            while(mpp.size()>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        //tc=O(n^2) sc=O(n)
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     Map<Integer,Integer> mpp=new HashMap<>();

        //     for(int j=i;j<nums.length;j++){
        //         mpp.put(nums[j],mpp.getOrDefault(nums[j],0)+1);

        //         if(mpp.size()==k){
        //             count++;
        //         }
        //         else if(mpp.size()>k) break;
        //     }
        // }
        // return count;

        //tc=O(2n) sc=O(n)
        return func(nums,k)-func(nums,k-1);
    }
}