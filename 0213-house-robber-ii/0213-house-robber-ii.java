class Solution {
    private int solve(int ind, int start, int[] nums, int[] dp) {
        if (ind < start) return 0;
        if (ind == start) return nums[start];
        if (dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + solve(ind - 2, start, nums, dp);
        int notPick = solve(ind - 1, start, nums, dp);
        return dp[ind] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int excludeFirst = solve(n - 1, 1, nums, dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int excludeLast = solve(n - 2, 0, nums, dp2);
        return Math.max(excludeFirst, excludeLast);
    }
}
