class Solution {
    public int[] findNse(int arr[]){
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            // use ">=" to deal with duplicate elements
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
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
    public int sumSubarrayMins(int[] arr) {
        //Tc=O(5n) sc=O(5n)
        int nse[]=findNse(arr);
        int pse[]=findPse(arr);

        long mod=(long)1e9+7;
        long total=0;
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            total = (total + ((long)left * right % mod * arr[i] % mod)) % mod;
        }
        return (int)total;
    }
}