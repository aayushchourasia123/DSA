class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        //tc=O(m+n) sc=O(1)
        int row=mat.length;
        int col=mat[0].length;
        int i=0,j=col-1;
        while(i<row && j>=0){
            if(mat[i][j]==x) return true;
            
            else if(mat[i][j]>x){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}