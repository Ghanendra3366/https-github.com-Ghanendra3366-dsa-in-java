class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni < 0 || ni >= m || nj < 0 || nj >= n
                                || grid[ni][nj] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}