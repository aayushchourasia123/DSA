class MedianFinder {
    PriorityQueue<Integer> left_maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right_minHeap=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left_maxHeap.isEmpty() || num<left_maxHeap.peek())
        {
            left_maxHeap.offer(num);
        }
        else{
            right_minHeap.offer(num);
        }

        if(Math.abs(left_maxHeap.size()-right_minHeap.size())>1){
            right_minHeap.offer(left_maxHeap.poll());
        }
        else if(left_maxHeap.size()<right_minHeap.size()){
            left_maxHeap.offer(right_minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(left_maxHeap.size()==right_minHeap.size()){
            return (left_maxHeap.peek()+right_minHeap.peek())/2.0;
        }
        return left_maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */