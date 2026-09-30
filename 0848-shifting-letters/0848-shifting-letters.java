class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long sum=0;
        int n=shifts.length;

        char ch[]=s.toCharArray();
        for(int i=n-1;i>=0;i--){
            sum+=shifts[i];
            ch[i]=(char)((ch[i]-'a'+sum)%26 +'a');
        }
        return String.valueOf(ch);
    }
}