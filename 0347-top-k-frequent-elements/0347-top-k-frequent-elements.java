class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // ⏱ Complexity
        // Counting: O(n)
        // Heap operations: O(m log k) (where m = number of unique elements).
        // Overall: O(n log k)
        // Space: O(n)

        if(nums.length==1) return nums;

        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int no:nums){
            mp.put(no,mp.getOrDefault(no,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[]=new int[k];
        int i=0;
        while(k>0){
            res[i++]=pq.poll()[0];
            k--;
        }
        return res;
    }
}