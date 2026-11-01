class Solution {
    public int minMoves(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        int n=nums.length;
        int min=Arrays.stream(nums).min().getAsInt();
        return sum-n*min;
    }
}