class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        dist[0][1] = 0;
        pq.add(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentWeight = current[0];
            int u = current[1];
            int countU = current[2];

            if (u == n - 1) {
                return currentWeight;
            }

            if (currentWeight > dist[u][countU]) {
                continue;
            }

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                int nextCount = (labels.charAt(v) == labels.charAt(u)) ? countU + 1 : 1;

                if (nextCount <= k) {
                    if (currentWeight + w < dist[v][nextCount]) {
                        dist[v][nextCount] = currentWeight + w;
                        pq.add(new int[]{dist[v][nextCount], v, nextCount});
                    }
                }
            }
        }

        return -1;
    }
}
