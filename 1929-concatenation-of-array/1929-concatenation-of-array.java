class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int ans[]=new int[2*n];
        int i=0;
        while(i<n){
            ans[i]=nums[i];
            i++;
        }
        int j=0;
        while(j<n){
            ans[i]=nums[j];
            i++;
            j++;
        }
        return ans;
    }
}