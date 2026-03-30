class Solution {
    public int largestRectangleArea(int[] heights) {
        //tc=O(2N) sc=O(n)
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element=heights[st.pop()];
                int nse=i,pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(element*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element=heights[st.pop()];
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(element*(nse-pse-1),maxArea);
        }
        return maxArea;
    }
}