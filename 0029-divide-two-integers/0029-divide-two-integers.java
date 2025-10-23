class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        // If both are equal
        if (dividend == divisor) return 1;

        // Determine sign of result
        boolean sign = (dividend >= 0) == (divisor >= 0);

        // Use long to avoid overflow during abs conversion
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            ans += (1 << cnt);
            n -= (d << cnt);
        }

        return sign ? ans : -ans;
    }
}
