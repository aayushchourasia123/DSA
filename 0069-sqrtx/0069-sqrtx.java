class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        int low=0,high=x/2;
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long val=(long)mid*mid;
            if(val==x){
                return mid;
            }
            if(val<x){
                res=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return res;
    }
}