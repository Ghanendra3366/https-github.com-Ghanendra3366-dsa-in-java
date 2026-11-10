class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 3); j < i; j++) {
                long jumpCost = costs[i - 1] + (long) (i - j) * (i - j);
                dp[i] = Math.min(dp[i], dp[j] + jumpCost);
            }
        }
        return (int) dp[n];
    }
}
