class Solution {
    public int longestConsecutive(int[] nums) {
        //tc=O(n) sc=O(n)
        if(nums.length==0) return 0;
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int longest=1;
        for(int el:st){
            if(!st.contains(el-1)){
                int count=1;
                int x=el;
                while(st.contains(x+1)){
                    count++;
                    x++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}