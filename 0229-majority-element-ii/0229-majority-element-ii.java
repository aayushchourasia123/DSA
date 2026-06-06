//class Solution {
    // public List<Integer> majorityElement(int[] nums) {
    //     //tc=O(n logn)
    //     //sc=O(1) (excluding result list)
    //     if(nums.length==1) return  Arrays.asList(nums[0]);
        
    //     if(nums.length==2){
    //         if(nums[0]==nums[1])
    //         return  Arrays.asList(nums[0]);
    //         else return Arrays.asList(nums[0],nums[1]);
    //     }
        

    //     List<Integer> ans=new ArrayList<>();
    //     Arrays.sort(nums);
    //     int var=nums[0];
    //     int count=1;
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i-1]==nums[i])
    //         {
    //             count++;
    //         }
    //         else{
    //             var=nums[i];
    //             count=1;
    //         }
    //         //!ans.contains(var) this to handle duplicates since duplicates to be added once only
    //         if(count>nums.length/3 && !ans.contains(var)){ 
    //             ans.add(var);
    //         }

    //     }
    //     return ans;
    // }
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //tc=O(2n) sc=O(1)
        int n=nums.length;
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=el2){
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=el1){
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1) cnt1++;
            else if(nums[i]==el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int num:nums){
            if(el1==num) cnt1++;
            if(el2==num) cnt2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(cnt1>n/3) ans.add(el1);
        if(cnt2>n/3) ans.add(el2);

        return ans;
    }
}