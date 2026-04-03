class Solution {
    public int celebrity(int mat[][]) {
        // code here
        //tc=O(n*m) + O(n) sc=O(2n)
        int knowMe[]=new int[mat.length];
        int iknow[]=new int[mat.length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(i!=j && mat[i][j]==1){
                    knowMe[j]++;
                    iknow[i]++;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            if(knowMe[i]==mat.length-1 && iknow[i]==0){
                return i;
            }
        }
        return -1;
    }
}