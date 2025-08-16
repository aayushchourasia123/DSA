class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //TC=O(n^4)
        // int n=nums.length;
        // List<List<Integer>> ans=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 int sum=nums[i]+nums[j]+nums[k]+nums[l];

        //                 if(sum==target){
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
        //                 Collections.sort(temp);
        //                 if(!ans.contains(temp)){
        //                     ans.add(temp);
        //                 }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return ans;
        
        //tc=O(n^3)
        //sc=O(1)
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        
        long tgt = (long) target;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==tgt){
                         ans.add(Arrays.asList(nums[i], nums[j], nums[k],nums[l]));
                         k++;
                         l--;
                         while(k<l && nums[k]==nums[k-1]) k++;
                         while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}