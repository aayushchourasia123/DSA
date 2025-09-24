// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        int sorted[]=arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(sorted[i],i);
        }
        
        for(int i=0;i<n;i++){
        int sortIdx=mp.get(arr[i]);
        if(Math.abs(i-sortIdx)>k) return "No";
        }
        return "Yes";
    }
}