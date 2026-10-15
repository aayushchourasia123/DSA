class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int res=0;
        for(int i=0;i<n;i++){
            Set<Integer> hs=new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(nums.get(j));
                res+=hs.size()*hs.size();
            }
        }
        return res;
    }
}