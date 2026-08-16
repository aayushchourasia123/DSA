// class Solution {
//     //memoized using dp
//     //tc=O(n*(2*sum)) sc=O(n*(2*sum))
//     public int ways(int i,int nums[],int target,int dp[][],int offset){
//         if(i==nums.length){
//             if(target==0) return 1;
//             else return 0;
//         }
//         if(target < -offset || target > offset) return 0;

//         int index=offset+target;
//         if(dp[i][index]!=-1) return dp[i][index];
//         int add=ways(i+1,nums,target-nums[i],dp,offset);
//         int sub=ways(i+1,nums,target+nums[i],dp,offset);
//         return dp[i][index]=add+sub;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int sum=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//         }
//         if(target>sum || target<-sum) return 0;
//         int offset=sum;
//         //i=>0 to n-1 | target -> -sum to sum
//         int dp[][]=new int[nums.length][2*sum +1];
//         for(int row[]:dp) Arrays.fill(row,-1);
//         return ways(0,nums,target,dp,offset);
//     }
// }

class Solution {
    //memoized using hashmap
    //tc=O(n*(2*sum)) sc=O(n*(2*sum))
    public int ways(int i, int nums[], int target, HashMap<String, Integer> dp) {

        if (i == nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        String key = i + "," + target;

        if (dp.containsKey(key))
            return dp.get(key);

        int add = ways(i + 1, nums, target - nums[i], dp);
        int sub = ways(i + 1, nums, target + nums[i], dp);

        int ans = add + sub;

        dp.put(key, ans);

        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {

        HashMap<String, Integer> dp = new HashMap<>();

        return ways(0, nums, target, dp);
    }
}