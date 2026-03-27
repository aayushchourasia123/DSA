class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        Integer nse[]=new Integer[arr.length];
        
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i]=st.peek();
            }
            else{
               nse[i]=-1; 
            } 
            
            st.push(arr[i]);
        }
        return new ArrayList<>(Arrays.asList(nse));
    }
}