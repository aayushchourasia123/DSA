class Solution {
    // public int helper(int n,int count){
    //     if(n<=1) return 1;

    //     return helper(n-1,count)+helper(n-2,count);
    // }
    // public int climbStairs(int n) {
    //    return helper(n,0);
    // }
    public int climbStairs(int n) {
        //tc=O(n) sc=O(1)
        if(n<=1) return 1;
        int prev=1,curr=1;
        for(int i=2;i<=n;i++){
            int temp=curr;
            curr=prev+curr;
            prev=temp;
        }
        return curr;
    }
}