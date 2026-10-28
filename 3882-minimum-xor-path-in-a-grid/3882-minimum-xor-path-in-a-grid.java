public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        final int MAX_XOR = 1024;
        
        boolean[][][] visited = new boolean[m][n][MAX_XOR];
        Queue<int[]> queue = new LinkedList<>();
        
        int startXor = grid[0][0];
        queue.offer(new int[]{0, 0, startXor});
        visited[0][0][startXor] = true;
        
        int minXor = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int currentXor = current[2];
            
            if (r == m - 1 && c == n - 1) {
                minXor = Math.min(minXor, currentXor);
                continue;
            }
            
            if (c + 1 < n) {
                int nextXor = currentXor ^ grid[r][c + 1];
                if (!visited[r][c + 1][nextXor]) {
                    visited[r][c + 1][nextXor] = true;
                    queue.offer(new int[]{r, c + 1, nextXor});
                }
            }
            
            if (r + 1 < m) {
                int nextXor = currentXor ^ grid[r + 1][c];
                if (!visited[r + 1][c][nextXor]) {
                    visited[r + 1][c][nextXor] = true;
                    queue.offer(new int[]{r + 1, c, nextXor});
                }
            }
        }
        
        return minXor == Integer.MAX_VALUE ? -1 : minXor;
    }
}
