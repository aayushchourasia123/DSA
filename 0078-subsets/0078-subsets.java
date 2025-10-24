class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //tc=O(2^n * n)
        //sc=O(2^n * n)
      int n=nums.length;
      int no_subset=1<<n;
      List<List<Integer>> ans = new ArrayList<>();
      for(int num=0;num<no_subset;num++){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if((num&(1<<i))!=0){
                list.add(nums[i]);
            }
        }
        ans.add(list);
      }
      return ans;
    }
}