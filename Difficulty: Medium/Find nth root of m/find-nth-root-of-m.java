class Solution {
    public int find(int no,int n){
        int res=1;
        for(int i=0;i<n;i++){
            res*=no;
        }
        return res;
    }
    public int nthRoot(int n, int m) {
        //TC=(n log m)
        // code here
        if(n==1) return m;
        int low=1,high=m/2;
        
        while(low<=high){
            int mid=(low+high)/2;
            int sq=find(mid,n);
            if(sq==m) return mid;
            else if(sq>m) high=mid-1;
            else low=mid+1;
            
        }
        return -1;
    }
}