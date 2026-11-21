class Solution {
    private List<Integer>[] adj;
    private int[] ans;
    private int[] lastSeen;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = new int[n];
        this.lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }
        dfs(0, -1);
        return ans;
    }
    private void dfs(int u, int p) {
        ans[u] = 1;
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];
        lastSeen[charIdx] = u;
        for (int v : adj[u]) {
            dfs(v, u);
        }
        int targetParent = (prevAncestor != -1) ? prevAncestor : p;
        if (targetParent != -1) {
            ans[targetParent] += ans[u];
        }
        lastSeen[charIdx] = prevAncestor;
    }
}
