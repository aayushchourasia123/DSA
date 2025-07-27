class Solution {
    //tc=O(n)
    //sc=O(n)
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
         if (n == 0) return 0; // handle empty array

        Set<Integer> st=new HashSet<>();
        //adding elements in hastset 
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        int longest1=1;
        // Find the longest sequence
        for(int it : st){
            //if 'it' is a starting number
            if(!st.contains(it-1)){ 
                //find consecutive numbers
                int count=1;
                int x=it;
                
                while(st.contains(x+1)){
                    count++;
                    x++;
                }
                 longest1=Math.max(longest1,count);
            }
        }
        return longest1;
    }

}