class Solution {
    public int longestValidParentheses(String s) {
        //tc=O(n) sc=O(n)
        // Stack<Integer> st=new Stack<>();
        // st.push(-1);
        // int n=s.length();
        // int ans=0;
        // for(int i=0;i<n;i++){
        //     char ch=s.charAt(i);
        //     if(ch=='(') st.push(i);
        //     else{
        //         st.pop();
        //         if(st.isEmpty()){
        //             st.push(i);
        //         }
        //         else{
        //             ans=Math.max(ans,i-st.peek());
        //         }
        //     }
        // }
        // return ans;

        int n=s.length();
        int res=0;
        int open=0,close=0;

        //left to right
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else close++;

            if(open==close) {
                res=Math.max(res,open+close);
            }
            else if(close>open){
                open=close=0;
            }
        }

        open=0;close=0;
        //right to left
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else close++;

            if(open==close) {
                res=Math.max(res,open+close);
            }
            else if(open>close){
                open=close=0;
            }
        }
        return res;
    }
}