class Solution {
    int maxLength(int arr[]) {
        // code here
        //tc=O(n^2) sc=O(1)
        // int n=arr.length;
        
        // int max=0;
       
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //          sum+=arr[j];
        //          if(sum==0){
                     
        //              max=Math.max(j-i+1,max);
        //          }
        //     }
        // }
        // return max;
        
        //tc=O(n)
        //sc=O(n)
        HashMap<Integer,Integer> mp=new HashMap<>();
        int sum=0,maxi=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                maxi=i+1;
            }
            else if(mp.get(sum)!=null){
                maxi=Math.max(maxi,i-mp.get(sum));
            }
            else mp.put(sum,i);
        }
        return maxi;
    }
}