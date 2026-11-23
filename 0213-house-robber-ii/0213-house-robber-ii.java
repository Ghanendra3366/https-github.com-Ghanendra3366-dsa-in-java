class Solution {
    private int solve(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            int pick = nums[start + i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[len - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int excludeFirst = solve(nums, 1, n - 1);
        int excludeLast = solve(nums, 0, n - 2);
        return Math.max(excludeFirst, excludeLast);
    }
}
