// User function Template for Java

class Solution {

    public boolean countSub(long arr[], long n) {
        //int k=0;
        // Your code goes here
        for(int i=0;i<n;i++){
            int leftChild=2*i+1;
            int rightChild=2*i+2;
             if (leftChild < n && arr[i] < arr[leftChild]) {
                return false;
            }
            if (rightChild < n && arr[i] < arr[rightChild]) {
                return false;
            }
            
        }
        
        return true;
    }
}