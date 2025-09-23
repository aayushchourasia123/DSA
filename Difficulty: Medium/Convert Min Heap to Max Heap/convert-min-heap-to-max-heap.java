// User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for(int i=(N/2)-1;i>=0;i--){
            hepify(arr,N,i);
        }
    }
         static void hepify(int arr[],int n,int idx){
            while(true){
                int leftChild=2*idx+1;
                int rightChild=2*idx+2;
                int largest=idx;
                
                if(leftChild<n && arr[largest]<arr[leftChild])
                {
                    largest=leftChild;
                }
                if(rightChild<n && arr[largest]<arr[rightChild])
                {
                    largest=rightChild;
                }
                
                if(largest!=idx){
                    int temp = arr[idx];
                    arr[idx] = arr[largest];
                    arr[largest] = temp;
                    idx=largest;
                }
                else{
                    break;
                }
            }
        }
    
}
