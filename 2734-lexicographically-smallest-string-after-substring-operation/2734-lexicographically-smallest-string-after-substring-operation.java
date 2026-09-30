class Solution {
    public String smallestString(String s) {
        char[]ch=s.toCharArray();
        int n=ch.length;
        boolean modified=false;
        int i=0;
        while(i<n && ch[i]=='a'){
            i++;
        }
        if(i==n){
            ch[n-1]='z';
        }
        while(i<n && ch[i]!='a'){
            ch[i++]--;
        }
        return String.valueOf(ch);
    }
}