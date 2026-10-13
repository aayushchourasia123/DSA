// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
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

class Solution {
    List<List<Integer>> res=new ArrayList<>();

    public void twoSum(int target,int i,int j,int nums[]){
        while(i<j){
            if(nums[i]+nums[j]>target) j--;
            else if(nums[i]+nums[j]<target) i++;
            else{
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j]==nums[j-1]) j--;
                res.add(Arrays.asList(-target,nums[i],nums[j]));
                i++;j--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //res.clear();
        int n=nums.length;
        if(n<3) return new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int n1=nums[i];
            int target=-n1;
            twoSum(target,i+1,n-1,nums);
        }
        return res;
    }
}