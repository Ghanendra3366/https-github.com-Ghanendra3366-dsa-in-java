class Solution {
    int n, timer;
    List<Integer>[] adj;
    int[] parent, depth, size, heavy, head, pos, seg;

    int dfs(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        int maxSize = 0;

        for (int v : adj[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            int sub = dfs(v, u);
            size[u] += sub;

            if (sub > maxSize) {
                maxSize = sub;
                heavy[u] = v;
            }
        }

        return size[u];
    }

    void decompose(int u, int h) {
        head[u] = h;
        pos[u] = timer++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : adj[u]) {
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    void build(int node, int l, int r, char[] s, int[] invPos) {
        if (l == r) {
            seg[node] = 1 << (s[invPos[l]] - 'a');
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid, s, invPos);
        build(node * 2 + 1, mid + 1, r, s, invPos);
        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    void update(int node, int l, int r, int idx, int mask) {
        if (l == r) {
            seg[node] = mask;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, mask);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, mask);
        }

        seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return seg[node];

        int mid = (l + r) / 2;
        int ans = 0;

        if (ql <= mid) {
            ans ^= query(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            ans ^= query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        return ans;
    }

    int pathQuery(int u, int v) {
        int mask = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= query(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        mask ^= query(1, 0, n - 1, pos[u], pos[v]);
        return mask;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(heavy, -1);

        dfs(0, -1);
        timer = 0;
        decompose(0, 0);

        int[] invPos = new int[n];

        for (int i = 0; i < n; i++) {
            invPos[pos[i]] = i;
        }

        seg = new int[4 * n];
        char[] chars = s.toCharArray();
        build(1, 0, n - 1, chars, invPos);

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);
                chars[u] = c;
                update(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int v = Integer.parseInt(parts[2]);
                int mask = pathQuery(u, v);
                result.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }

        return result;
    }
}