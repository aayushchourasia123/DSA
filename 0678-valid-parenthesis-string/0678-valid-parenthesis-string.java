// class Solution {
//     public boolean checkValidString(String s) {
//         //tc=O(3^n) sc=O(n)
//         return helper(s,0,0);

//     }
//     public boolean helper(String s,int idx,int cnt){
//         if(cnt<0) return false;
//         if(idx==s.length()) return cnt==0;

//         if(s.charAt(idx)=='(') return helper(s,idx+1,cnt+1);
//         if(s.charAt(idx)==')') return helper(s,idx+1,cnt-1);
//         return helper(s,idx+1,cnt+1) || helper(s,idx+1,cnt-1) || helper(s,idx+1,cnt);
//     } 
// }
class Solution {
    public boolean checkValidString(String s) {
        //tc=O(n) sc=O(1)
        int min=0,max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                max++;
                min++;
            }
            else if(ch==')'){
                max--;
                min--;
            }
            else{
                min--;
                max++;
            }
            if(min<0) min=0;
            if(max<0) return false;
        }
        return min==0;

    }
}