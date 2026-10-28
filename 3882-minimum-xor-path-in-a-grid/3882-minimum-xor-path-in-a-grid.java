public class Solution {
    private int m;
    private int n;
    private final int MAX_XOR = 1024;
    private Integer[][][] memo;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n][MAX_XOR];
        
        int result = dfs(0, 0, grid[0][0], grid);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int r, int c, int currentXor, int[][] grid) {
        if (r == m - 1 && c == n - 1) {
            return currentXor;
        }

        if (memo[r][c][currentXor] != null) {
            return memo[r][c][currentXor];
        }

        int minXor = Integer.MAX_VALUE;

        if (c + 1 < n) {
            int right = dfs(r, c + 1, currentXor ^ grid[r][c + 1], grid);
            minXor = Math.min(minXor, right);
        }

        if (r + 1 < m) {
            int down = dfs(r + 1, c, currentXor ^ grid[r + 1][c], grid);
            minXor = Math.min(minXor, down);
        }

        return memo[r][c][currentXor] = minXor;
    }
}
