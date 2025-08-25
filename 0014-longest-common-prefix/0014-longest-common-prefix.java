class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs== null || strs.length==0) return "";
        //tc=O(nlogn+m)
        //sc=O(1)
        Arrays.sort(strs); //sort lexicographically
        String first=strs[0];
        String last = strs[strs.length-1];
        int i=0;
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}