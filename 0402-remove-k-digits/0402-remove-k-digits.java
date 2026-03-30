class Solution {
    public String removeKdigits(String num, int k) {
        //tc=O(3n)+O(k) sc=O(2N)
        if(k==num.length()) return "0";
        Stack<Character> st=new Stack<>();
        for(char digit:num.toCharArray()){
            while(!st.isEmpty()&& k>0&& st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) res.append(st.pop());

        res.reverse();
        while(res.length()>0 && res.charAt(0)=='0') res.deleteCharAt(0);

        return res.length()>0?res.toString():"0";
    }
}