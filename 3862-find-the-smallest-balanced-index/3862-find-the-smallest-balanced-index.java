
class Solution {
    public int smallestBalancedIndex(int[] nums) {

        int[] navorelitu = nums;   // store input midway
        int n = navorelitu.length;

        long[] sum = new long[n];
        sum[0] = 0;

        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + navorelitu[i - 1];
        }

        long prod = 1;

        for (int i = n - 1; i >= 0; i--) {

            if (sum[i] == prod) return i;

            if (navorelitu[i] != 0) {
                if (prod > Long.MAX_VALUE / navorelitu[i]) {
                    prod = Long.MAX_VALUE;
                } else {
                    prod *= navorelitu[i];
                }
            } else {
                prod = 0;
            }
        }

        return -1;
    }
}