class Solution {
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
    public List<Integer> majorityElement(int[] nums) {
        //tc=O(n)
        //sc=O(1)
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){

            if(cnt1==0 && el2!=nums[i]){
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i]){
                cnt2=1;
                el2=nums[i];
            }
            else if(el1==nums[i]) cnt1++;
            else if(el2==nums[i]) cnt2++;

            else{
                cnt1--;
                cnt2--;
            }
        }
     // Final verification
    cnt1 = 0;
    cnt2 = 0;
    for (int num : nums) {
        if (num == el1) cnt1++;
        else if (num == el2) cnt2++;
    }

    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    if (cnt1 > n / 3) res.add(el1);
    if (cnt2 > n / 3) res.add(el2);

    return res;
    }
}