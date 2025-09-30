class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Arrays.sort(a);
        Arrays.sort(b);
        
        int n=a.length;
        for(int i=n-1;i>n-k-1;i--){
            for(int j=n-1;j>n-k-1;j--){
                int sum=a[i]+b[j];
                 if(pq.size()<k) pq.add(sum);
                 else{
                     if(pq.peek()<sum){
                         pq.remove();
                         pq.add(sum);
                     }
                     else break;
                 }
            }
        }
        ArrayList<Integer> lt=new ArrayList<>();
        while(!pq.isEmpty()){
            lt.add(0,pq.poll());
        }
        return lt;
    }
}