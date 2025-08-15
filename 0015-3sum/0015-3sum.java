class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //tc=O(n^3)
        //sc=O(1) 
        // List<List<Integer>> ans=new ArrayList<>();
        
        // int n=nums.length;
        // for (int i = 0; i < n - 2; i++) {
        //     for (int j = i + 1; j < n - 1; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(temp);  to avoid (a,b,c) vs (c,b,a) being different
        //                 if (!ans.contains(temp)) {
        //                     ans.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return ans;

        //TC=O(n^2)
        //SC=O(n^2)
        // int n=nums.length;
        // Set<List<Integer>> st=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     Set<Integer> hashset=new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         int third=-(nums[i]+nums[j]);
        //         if (hashset.contains(third)) {
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
        //             temp.sort(null);
        //             st.add(temp);
        //         }
        //         hashset.add(nums[j]);
        //     }
        // }

            
        //  // store the set elements in the answer:
        // List<List<Integer>> ans = new ArrayList<>(st);
        // return ans;

        //TC=O(N^2)+O(N LOGN)
        //SC=O(1)
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                // Skip duplicates for left and right
                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;

                }
            }
        }
        return ans;
    }
}