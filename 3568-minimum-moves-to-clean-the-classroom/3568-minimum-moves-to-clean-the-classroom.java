class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        int startR = 0;
        int startC = 0;
        int trashCount = 0;

        int[][] id = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                id[i][j] = -1;

                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = trashCount++;
                }
            }
        }

        int total = 1 << trashCount;

        int[][][] dist = new int[n * m][total][energy + 1];

        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < total; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        dist[startR * m + startC][0][energy] = 0;
        q.offer(new int[]{startR, startC, 0, energy});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];

            int moves = dist[r * m + c][mask][e];

            if (mask == total - 1) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int ne = e - 1;

                if (ne < 0) {
                    continue;
                }

                int nmask = mask;

                if (classroom[nr].charAt(nc) == 'L') {
                    nmask |= (1 << id[nr][nc]);
                }

                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }

                int pos = nr * m + nc;

                if (dist[pos][nmask][ne] == -1) {
                    dist[pos][nmask][ne] = moves + 1;
                    q.offer(new int[]{nr, nc, nmask, ne});
                }
            }
        }

        return -1;
    }
}