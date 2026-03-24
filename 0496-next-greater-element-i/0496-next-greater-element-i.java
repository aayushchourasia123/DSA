class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            // Remove all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            // Assign next greater
            if (st.isEmpty()) {
                mp.put(curr, -1);
            } else {
                mp.put(curr, st.peek());
            }

            // Push current
            st.push(curr);
        }
        int ans[]=new int[nums1.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=mp.get(nums1[i]);
        }
        return ans;
    }
}