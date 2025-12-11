// User function Template for Java

class Solution {
    
    public int firstOccurence(int arr[],int n,int x){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            if(arr[mid]==x){
                ans=mid;
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=low+1;
            }
            else {
                high=mid-1;
            }
        }
        return ans;
    }
    
    //Time: O(R * log C) where R = rows, C = cols (binary search per row).
    //Space: O(1)
    public int rowWithMax1s(int arr[][]) {
        // code here
        int maxOnes=-1;
        int idx=-1;
        int col=arr[0].length;
        for(int i=0;i<arr.length;i++){
            
            int idxOfFirst=firstOccurence(arr[i],col,1);
            int noOfone=(idxOfFirst==-1) ? 0:(col-idxOfFirst);
            if(noOfone>maxOnes){
                maxOnes=noOfone;
                idx=i;
            }
        }
        return idx;
    }
}