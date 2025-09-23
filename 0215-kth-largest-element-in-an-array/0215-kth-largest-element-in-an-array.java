class Solution {
    public int findKthLargest(int[] nums, int k) {
        //TC=O(n log k)) sc=O(k) heap size
        PriorityQueue<Integer> mh=new PriorityQueue<>(); //minheap
        for(int no:nums){
            mh.add(no);
            if(mh.size()>k){
                mh.poll();
            }
        }
        return mh.peek();
       
    }
}