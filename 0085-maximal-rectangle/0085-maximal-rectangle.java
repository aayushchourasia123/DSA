class Solution {
    public static int largestRectangleHistogram(int[] height){
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()]>height[i]){
                int element=height[st.pop()];
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(element*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
              int element=height[st.pop()];
                int nse=height.length;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(element*(nse-pse-1),maxArea);  
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int height[]=new int[matrix[0].length];
        int maxArea=0;
        //For each row → O(m)
        //For all rows → O(n × m)
        //tc=O(n*m) sc=O(m)(height) + O(m)(stack) = O(m)
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            int area=largestRectangleHistogram(height);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}