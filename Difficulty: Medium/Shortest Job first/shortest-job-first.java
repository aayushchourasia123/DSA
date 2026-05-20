class Solution {
    static int solve(int bt[]) {
        // code here
          int n=bt.length;
          Arrays.sort(bt);
          int t=0,wt=0;
          for(int i=0;i<n;i++){
              wt+=t;
              t+=bt[i];
          }
          return wt/n;
    }
}
