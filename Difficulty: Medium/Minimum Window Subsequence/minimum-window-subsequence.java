class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        //tc=O(n*m) sc=O(1)
        int n=s1.length(),m=s2.length();
        int minlen=Integer.MAX_VALUE;
        int startIdx=-1;
        int i=0;
        while(i<n){
            int j=0;
            
            //forward match
            while(i<n){
                if(s1.charAt(i)==s2.charAt(j)){
                    j++;
                    if(j==m) break;
                }
                i++;
            }
            if(i==n) break; 
            int end=i;
            j=m-1;
            while(i>=0){
                if(s1.charAt(i)==s2.charAt(j)){
                    j--;
                    if(j<0) break;
                }
                i--;
            }
            int start=i;
            int len=end-start+1;
            if(len<minlen){
                minlen=len;
                startIdx=start;
            }
            i=start+1;
        }
        return startIdx==-1? "":s1.substring(startIdx,startIdx+minlen);
    }
}
