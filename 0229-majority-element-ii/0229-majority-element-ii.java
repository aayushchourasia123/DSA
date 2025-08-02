class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==1) return  Arrays.asList(nums[0]);
        
        if(nums.length==2){
            if(nums[0]==nums[1])
            return  Arrays.asList(nums[0]);
            else return Arrays.asList(nums[0],nums[1]);
        }
        

        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int var=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i])
            {
                count++;
            }
            else{
                var=nums[i];
                count=1;
            }
            //!ans.contains(var) this to handle duplicates since duplicates to be added once only
            if(count>nums.length/3 && !ans.contains(var)){ 
                ans.add(var);
            }

        }
        return ans;
    }
}