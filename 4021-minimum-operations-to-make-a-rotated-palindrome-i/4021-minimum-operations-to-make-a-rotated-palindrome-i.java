class Solution {
    public void rotate(StringBuilder sb,int d){
        if(sb==null) return;
        int n=sb.length();
        d=d%n;
        String front=sb.substring(0,d);
        sb.append(front);
        sb.delete(0,d);
        return;
    }
    public int minOperations(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            int curr=r;
            StringBuilder sb=new StringBuilder(s);
            rotate(sb,r);
            for(int i=0;i<n/2;i++){
                char ch1=sb.charAt(i);
                char ch2=sb.charAt(n-i-1);
                int diff=Math.abs(ch1-ch2);
                curr+=Math.min(diff,26-diff);
            }
            ans=Math.min(ans,curr);
        }
        return ans;    
    }
}