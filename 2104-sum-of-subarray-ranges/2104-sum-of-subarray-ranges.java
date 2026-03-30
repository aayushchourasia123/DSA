class Solution {
    public int[] findPge(int arr[]){
        Stack<Integer> st=new Stack<>();
        int pge[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
    public int[] findNge(int arr[]){
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nge;
    }
    public long sumOfLargest(int arr[]){
        int[] nge=findNge(arr);
        int[] pge=findPge(arr);
        long total=0;
        for(int i=0;i<arr.length;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            total=(total+((long)left*right*arr[i]));
        }
        return total;
    }

    public int[] findPse(int arr[]){
        Stack<Integer> st=new Stack<>();
        int pse[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public int[] findNse(int arr[]){
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
    }
    public long sumOfSmallest(int arr[]){
        int[] nse=findNse(arr);
        int[] pse=findPse(arr);
        long total=0;
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            total=(total+((long)left*right*arr[i]));
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        return sumOfLargest(nums)-sumOfSmallest(nums);
    }
}