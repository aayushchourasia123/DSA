class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        //tc=O(n) sc=O(1)
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int preXor=0;
        long count=0;
        for(int i=0;i<arr.length;i++){
            preXor^=arr[i];
            int req=preXor^k;
            if(mp.containsKey(req)){
                count+=mp.get(req);
            }
            mp.put(preXor,mp.getOrDefault(preXor,0)+1);
        }
       
        return count;
    }
}