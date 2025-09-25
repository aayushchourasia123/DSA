// User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        
        //total TC=O(nlogn) sc=O(n)
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int no:arr){
           pq.add(no); //nlogn
       }
       Map<Integer,Integer> mp=new HashMap<>();
       int k=1;
       while(!pq.isEmpty()){
           int v=pq.poll();
           if(!mp.containsKey(v)){
           mp.put(v,k++);//nlogn for polling and n for filling hashmap
           }
       }
       int ans[]=new int[N];
       for(int i=0;i<N;i++){
           ans[i]=mp.get(arr[i]); // ans filling O(N)
       }
       return ans;
    }
}
