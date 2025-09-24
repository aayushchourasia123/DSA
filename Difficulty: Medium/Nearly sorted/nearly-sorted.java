class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        //TC=O(n logk)
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int idx=0;
        for(int i=0;i<arr.length;i++){
            
            pq.add(arr[i]);
            if(pq.size()==k+1){ //store element till k+1 in heap
                arr[idx++]=pq.poll();
            }
        } 
        while(!pq.isEmpty()){
                arr[idx++]=pq.poll();
            }
    }
}
