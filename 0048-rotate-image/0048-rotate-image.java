class Solution {
    public void rotate(int[][] matrix) {
        //tc=O(n) sc=O(1)
       int n=matrix.length;
       //transpose row->col and col->row tc=O(n/2)
       for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
       }

       //now reverse tc=O(n/2)
       for(int i=0;i<n;i++){
        for(int j=0;j<n/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][n-j-1];
            matrix[i][n-j-1]=temp;
        }
       }
    }
}