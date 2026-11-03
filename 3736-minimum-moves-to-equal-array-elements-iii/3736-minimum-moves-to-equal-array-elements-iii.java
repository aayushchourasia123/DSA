class Solution {
    public int minMoves(int[] nums) {
        int max=Arrays.stream(nums).max().getAsInt();
        int sum=Arrays.stream(nums).sum();
        int n=nums.length;

        return n*max-sum;
    }
}