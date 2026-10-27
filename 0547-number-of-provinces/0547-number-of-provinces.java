class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}