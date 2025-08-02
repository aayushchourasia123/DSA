class Solution {
    public int subarraySum(int[] nums, int k) {
        //TC=O(N)
        //SC=O(N)
        HashMap<Integer, Integer> mp=new HashMap();
        mp.put(0,1); //frequncy of 0 is 1
        int presum=0,cnt=0 ;
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int remove=presum-k;//calulating x-k
            
    //if remove exit then cnt will add with frequency of remove else 0 will be added
            cnt+=mp.getOrDefault(remove,0);
            
            //put presum in hashmap if already exit its frequency will be increase 
            mp.put(presum,mp.getOrDefault(presum,0) + 1); 
        }
        return cnt;

    }
}