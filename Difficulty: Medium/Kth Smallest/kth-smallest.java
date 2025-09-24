// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> mh=new PriorityQueue<>();
        
        for(int no :arr){
            mh.add(no);
        }
        for(int i=0;i<k-1;i++){
            mh.poll();
        }
        return mh.peek();
    }
}
