class Solution {
    public String removeOuterParentheses(String s) {
        //tc=O(n)
        //sc=O(1)
        int count=0;
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<s.length();i++){
        char c=s.charAt(i);

        if(c=='('){
            if(count>0) ans.append(c);  // skip outermost '(
            count++;                     
        }
        else{
            count--;
            if(count>0) ans.append(c); // skip outermost ')'
        }
        }
        return ans.toString();
    }
}