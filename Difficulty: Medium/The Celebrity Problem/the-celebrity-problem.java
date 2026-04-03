class Solution {
    public int celebrity(int mat[][]) {
        // code here
        // //tc=O(n*m) + O(n) sc=O(2n)
        // int knowMe[]=new int[mat.length];
        // int iknow[]=new int[mat.length];
        
        // for(int i=0;i<mat.length;i++){
        //     for(int j=0;j<mat.length;j++){
        //         if(i!=j && mat[i][j]==1){
        //             knowMe[j]++;
        //             iknow[i]++;
        //         }
        //     }
        // }
        // for(int i=0;i<mat.length;i++){
        //     if(knowMe[i]==mat.length-1 && iknow[i]==0){
        //         return i;
        //     }
        // }
        // return -1;
        
        //tc=O(2n) sc=O(1)
        int top=0,down=mat.length-1;
        while(top<down){
            if(mat[top][down]==1){
                top++;
            }
            else if(mat[down][top]==1){
                down--;
            }
            else{
                top++;
                down--;
            }
        }
        if(top>down) return -1;
        
        for(int i=0;i<mat.length;i++){
            
            // if(mat[top][i]==0&&mat[i][top]==1){
            //     continue;
            // }
            if(i==top) continue;

            if(mat[top][i]==1 || mat[i][top]==0){
                 return -1;
            }
        }
        return top;
        
    }
}
