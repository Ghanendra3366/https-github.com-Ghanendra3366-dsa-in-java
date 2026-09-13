class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> points1 = new ArrayList<>();
        List<int[]> points2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) points1.add(new int[]{i, j});
                if (img2[i][j] == 1) points2.add(new int[]{i, j});
            }
        }
        int[][] shiftCounts = new int[2 * n + 1][2 * n + 1];
        int maxOverlap = 0;
        for (int[] p1 : points1) {
            for (int[] p2 : points2) {
                int rowShift = p2[0] - p1[0] + n;
                int colShift = p2[1] - p1[1] + n;
                shiftCounts[rowShift][colShift]++;
                maxOverlap = Math.max(maxOverlap, shiftCounts[rowShift][colShift]);
            }
        }
        return maxOverlap;
    }
}
