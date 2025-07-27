class Solution {

    //tc=O(m*n)
    //sc=O(m+n)
    // public void setZeroes(int[][] matrix) {
    //     int m=matrix.length;
    //     int n=matrix[0].length;

    //     boolean row[]=new boolean[m];
    //     boolean col[]=new boolean[n];
        
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){

    //             if(matrix[i][j]==0){
    //                row[i]=true;
    //                col[j]=true;
    //             }
    //         }
    //     }
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(row[i] || col[j]){
    //                 matrix[i][j]=0;
    //             }
    //         }
    //     }
    // }
    public void setZeroes(int[][] matrix) {
        //tc=O(n*m)
        //sc=O(1)
    //col[m]={0} ->matrix[0][..]
    //row[n]={0} ->matrix[..][0]
    int n=matrix.length;
    int m=matrix[0].length;
    int col0=1;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(matrix[i][j]==0){
                //mark the i'th row
                matrix[i][0]=0;
                //mark the j'th col
                if(j!=0)
                matrix[0][j]=0;

                else col0=0;
            }
        }
    }
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){

            if(matrix[i][j]!=0){
                //check row and col
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }
    if(matrix[0][0]==0){
        for(int j=0;j<m;j++){
            matrix[0][j]=0;
        } 
    }
    if(col0==0){
        for(int i=0;i<n;i++){
            matrix[i][0]=0;
        } 
    }
    }

}
       