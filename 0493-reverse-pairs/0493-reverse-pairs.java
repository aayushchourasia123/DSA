// class Solution {
//     public int reversePairs(int[] nums) {
//         //tc=O(n^2) sc=O(1)
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]>2*nums[j]) count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public void merge(int nums[],int l,int mid,int h){
        int temp[]=new int[h-l+1];
        int st=l;
        int right=mid+1;
        int i=0;
        while(l<=mid && right<=h){
            if(nums[l]<nums[right]){
                temp[i]=nums[l];
                l++;
            }
            else{
                temp[i]=nums[right];
                right++;
            }
            i++;
        }
        while(l<=mid){
            temp[i]=nums[l];
            l++;
            i++;
        }
        while(right<=h){
            temp[i]=nums[right];
            right++;
            i++;
        }
        for(int k=0,j=st;k<temp.length;k++,j++){
            nums[j]=temp[k];
        }
    }
    public int countPair(int nums[],int l,int mid,int h){
        int cnt=0;
        int right=mid+1;
        for(int i=l;i<=mid;i++){
            while(right<=h && nums[i]>2L*nums[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
    public int mergeSort(int nums[],int l,int h){
        int cnt=0;
        if(l>=h) return cnt;
        int mid=(l+h)/2;
        cnt+=mergeSort(nums,l,mid);
        cnt+=mergeSort(nums,mid+1,h);
        cnt+=countPair(nums,l,mid,h);
        merge(nums,l,mid,h);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        //tc=O(2nlogn) sc=O(n)
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}