class Solution {
    public int firstMissingPositive(int[] nums) {
        //tc=O(n)
        //sc=O(n)
        // HashSet<Integer> hs=new HashSet<>();
        // int smp=1;
        // for(int x:nums){
        //     if(x>0) hs.add(x);
        // }
        // while(hs.contains(smp)){
        //     smp++;
        // }
        // return smp;

        //tc=O(n) sc=O(1)
        int n=nums.length;
        boolean contains1=false;
        for(int i=0;i<n;i++){
            if(nums[i]==1) contains1=true;

            if(nums[i]<=0 || nums[i]>n){
                nums[i]=1;
            }
        }
        if(!contains1) return 1;
        for(int i=0;i<n;i++){
            int no=Math.abs(nums[i]);
            int idx=no-1;
            if(nums[idx]<0) continue;
            nums[idx]*=-1;
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}