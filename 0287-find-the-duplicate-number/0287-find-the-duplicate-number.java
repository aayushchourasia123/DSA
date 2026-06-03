// class Solution {
//     public int findDuplicate(int[] nums) {
//         //tc=O(n^2) sc=O(1)
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<nums.length;i++){
//             max=Math.max(nums[i],max);
//         }
//         int val=0;
//         for(int i=1;i<=max;i++){
//             int count=0;
//             for(int j=0;j<nums.length;j++){
//                 if(nums[j]==i){
//                     count++;
//                 }
//             }
//             if(count>1){
//                 val=i;
//                 break;
//             }
//         }
//         return val;
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
        //tc=O(n) sc=O(1)
        //Floyd's Tortoise and Hare algorithm
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast);

        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}