class Solution {
    static int cnt=0;
    static void mergeSort(int arr[],int st,int ed){
        if(st<ed){
            int mid=st+(ed-st)/2;
            mergeSort(arr,st,mid);
            mergeSort(arr,mid+1,ed);
            merge(arr,st,mid,ed);
        }
    }
    public static void merge(int arr[],int st,int mid,int ed){
        int temp[]=new int[ed-st+1];
        int left=st;
        int right=mid+1;
        int i=0;
        while(left<=mid && right<=ed){
            if(arr[left]<=arr[right]){
                temp[i]=arr[left];
                left++;
            }
            else{
                cnt+=(mid-left+1);
                temp[i]=arr[right];
                right++;
            }
            i++;
        }
        while(left<=mid){
            temp[i]=arr[left];
            left++;
            i++;
        }
        while(right<=ed){
            temp[i]=arr[right];
            right++; 
            i++;
        }
        for(int k=0,j=st;k<temp.length;k++,j++){
            arr[j]=temp[k];
        }
    }
    static int inversionCount(int arr[]) {
        // Code Here
        // int n=arr.length;
        // int count=0;
        // for(int i=0;i<=n-2;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]>arr[j]) count++;
        //     }
        // }
        // return count;
        
        //tc=O(n log n) sc=O(n)
        cnt=0;//cnt is global variable to reset it everytime function we assign cnt=0 inside function
        mergeSort(arr,0,arr.length-1);
        return cnt;
    }
}