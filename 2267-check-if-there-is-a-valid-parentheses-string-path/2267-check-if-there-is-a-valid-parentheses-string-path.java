class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        Boolean[][][] memo = new Boolean[m][n][(m + n) / 2 + 1];
        return dfs(grid, 0, 0, 0, m, n, memo);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int bal, int m, int n, Boolean[][][] memo) {
        bal += (grid[r][c] == '(') ? 1 : -1;
        
        if (bal < 0 || bal > (m + n) / 2) {
            return false;
        }
        
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }
        
        if (memo[r][c][bal] != null) {
            return memo[r][c][bal];
        }
        
        boolean res = false;
        if (r + 1 < m) {
            res = res || dfs(grid, r + 1, c, bal, m, n, memo);
        }
        if (c + 1 < n) {
            res = res || dfs(grid, r, c + 1, bal, m, n, memo);
        }
        
        return memo[r][c][bal] = res;
    }
}
