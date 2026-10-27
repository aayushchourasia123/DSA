class Solution {
    public String[] createGrid(int m, int n) {
        String arr[]=new String[m];
        String str="";
        for(int i=0;i<n;i++){
            str+=".";
        }
        arr[0]=str;
        int k=1;
        for(int i=1;i<m;i++){
            str="";
            for(int j=0;j<n;j++){
                if(j==n-1)str+=".";
                else str+="#";
            }
            arr[i]=str;
        }
        return arr;
    }
}