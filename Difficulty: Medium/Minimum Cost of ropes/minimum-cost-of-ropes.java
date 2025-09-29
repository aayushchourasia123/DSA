class Solution {
    public static int minCost(int[] arr) {
        // code here
        //tc=(nlogn)
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int no:arr){
            pq.add(no); //nlog n
        }
        int cost=0;
        while(pq.size()>=2){
            int first=pq.poll(); //log n
            int second=pq.poll();
            cost+=first+second;
            pq.add(first+second); //(log n-1)
        }
       return cost; 
    }
}