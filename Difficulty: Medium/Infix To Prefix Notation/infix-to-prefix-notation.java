// class Solution {
//     public static String reverse_Bracket(String s){

//         StringBuilder rev = new StringBuilder(s);
//         rev.reverse();

//         for(int i=0;i<rev.length();i++){
//             if(rev.charAt(i)=='(')
//                 rev.setCharAt(i,')');
//             else if(rev.charAt(i)==')')
//                 rev.setCharAt(i,'(');
//         }

//         return rev.toString();
//     }
//     public static int priority(char ch){
//         if(ch=='^') return 3;
//         else if(ch=='*' || ch=='/') return 2;
//         else if(ch=='+' || ch=='-') return 1;
//         else return -1;
//     }
//     public String infixToPrefix(String s) {
//         // code here
//         StringBuilder sb=new StringBuilder();
//         Stack<Character> st=new Stack<>();
//         String finalS=reverse_Bracket(s);
        
//         int i=0;
//         while(i<finalS.length()){
//             char ch=finalS.charAt(i);
//             if(Character.isLetterOrDigit(ch)){
//                 sb.append(ch);
//             }
//             else if(ch=='(') st.push(ch);
//             else if(ch==')'){
//                 while(!st.isEmpty() && st.peek()!='('){
//                     sb.append(st.pop());
//                 }
//                 st.pop();
//             }
//             else{
//                 while(!st.isEmpty() &&
//                 (priority(ch)<priority(st.peek()) ||
//                 (priority(ch)==priority(st.peek()) && ch!='^'))){
//                     sb.append(st.pop());
//                 }
//                 st.push(ch);
//             }
//             i++;
//         }
//         while(!st.isEmpty()){
//             sb.append(st.pop());
//         }
//         sb.reverse();
//         return sb.toString();
//     }
// }
import java.util.*;

class Solution {

    public static String reverse_Bracket(String s){

        StringBuilder rev = new StringBuilder(s);
        rev.reverse();

        for(int i=0;i<rev.length();i++){
            if(rev.charAt(i)=='(')
                rev.setCharAt(i,')');
            else if(rev.charAt(i)==')')
                rev.setCharAt(i,'(');
        }

        return rev.toString();
    }

    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        else return -1;
    }

    public String infixToPrefix(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String finalS = reverse_Bracket(s);

        for(int i=0;i<finalS.length();i++){

            char ch = finalS.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }

            else if(ch=='('){
                st.push(ch);
            }

            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty()) st.pop();
            }

            else{
                while(!st.isEmpty() &&
                      (priority(ch) < priority(st.peek()) ||
                      (priority(ch) == priority(st.peek()) && ch == '^'))){
                    sb.append(st.pop());
                }

                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}