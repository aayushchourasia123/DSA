class Solution {
    public int majorityElement(int[] nums) {
        // TC=O(NlogN) SC=O(N)    
    //    Map<Integer,Integer> mp=new HashMap<>();
    //    for(int i=0;i<nums.length;i++){
    //     int value=mp.getOrDefault(nums[i],0);
    //     mp.put(nums[i],value+1);
    //    }
    //    for(Map.Entry<Integer,Integer> it : mp.entrySet()){
    //     if(it.getValue()>(nums.length)/2)
    //     {
    //         return it.getKey();
    //     }
    //    }
    //    return -1;

    //tc=O(n) sc=O(1)
        int cnt=0;
        int el=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                el=nums[i];
                
            }
            cnt+= el==nums[i]?1:-1;
        }
        return el;
    }
}