class KthLargest {
    //tc=O(k) for insertion
    //O(no. of times add*logk for remove add)
    //overall TC=O(k+10^4logk) sc=O(k)
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int no:nums){
            add(no);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k || pq.peek()<val){
            pq.offer(val);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */