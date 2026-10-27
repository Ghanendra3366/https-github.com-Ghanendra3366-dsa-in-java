class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] d : dir) {
                    int ni = cell[0] + d[0];
                    int nj = cell[1] + d[1];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < m &&
                        grid[ni][nj] == 1) {

                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        fresh--;
                    }
                }
            }
            time++; 
        }

        return fresh == 0 ? time : -1;
    }
}