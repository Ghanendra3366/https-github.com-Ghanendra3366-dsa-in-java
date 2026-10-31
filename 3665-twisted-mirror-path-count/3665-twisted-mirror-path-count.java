class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;
        
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int prevDown = dp[c + 1][1];
                    int prevRight = dp[c][0];
                    dp[c + 1][0] = prevDown;
                    dp[c + 1][1] = prevRight;
                } else {
                    int total = (dp[c + 1][1] + dp[c][0]) % MOD;
                    dp[c + 1][0] = total;
                    dp[c + 1][1] = total;
                }
            }
            dp[0][0] = 0;
            dp[0][1] = 0;
        }
        
        return dp[n][0];
    }
}
