class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        //tc=O(2*(nlog n + n)) sc=O(1)
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0,cnt=0,maxcnt=-1;
        while(i<arr.length){
            if(arr[i]<=dep[j]){
                cnt++;
                i++;
            }
            else{
                cnt--;
                j++;
            }
            maxcnt=Math.max(maxcnt,cnt);
        }
       return maxcnt; 
    }
}
