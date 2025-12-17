class Solution {
    public int upperBound(int mat[],int x,int n){
        int ans=n;
        int low=0,high=mat.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public int CountlessThanEqual(int mat[][],int mid,int n ,int m){
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt+=upperBound(mat[i],mid,m);
        }
        return cnt;
    }
    public int median(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int req=(n*m)/2;
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            l=Math.min(l,mat[i][0]);
            h=Math.max(h,mat[i][m-1]);
        }
        
        while(l<=h){
            int mid=(l+h)/2;
            int smallerEqual=CountlessThanEqual(mat,mid,n,m);
            if(smallerEqual<=req){
                l=mid+1;
            }
            else h=mid-1;
        }
        return l;
    }
}