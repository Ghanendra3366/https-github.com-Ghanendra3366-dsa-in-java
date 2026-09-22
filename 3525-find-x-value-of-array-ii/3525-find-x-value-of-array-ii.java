class Solution {
    static class Node {
        int[] remain;
        int prod;

        Node(int k) {
            remain = new int[k];
            prod = 1;
        }
    }

    private int K;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.K = k;
        int n = nums.length;
        tree = new Node[4 * n];
        build(nums, 0, 0, n - 1);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(0, 0, n - 1, idx, val);
            Node res = query(0, 0, n - 1, start, n - 1);
            ans[i] = res.remain[x];
        }
        return ans;
    }

    private void build(int[] nums, int node, int start, int end) {
        tree[node] = new Node(K);
        if (start == end) {
            int val = nums[start] % K;
            tree[node].remain[val] = 1;
            tree[node].prod = val;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, 2 * node + 1, start, mid);
        build(nums, 2 * node + 2, mid + 1, end);
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int v = val % K;
            Arrays.fill(tree[node].remain, 0);
            tree[node].remain[v] = 1;
            tree[node].prod = v;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node + 1, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 2, mid + 1, end, l, r);
        }
        Node leftNode = query(2 * node + 1, start, mid, l, r);
        Node rightNode = query(2 * node + 2, mid + 1, end, l, r);
        return merge(leftNode, rightNode);
    }

    private Node merge(Node left, Node right) {
        Node res = new Node(K);
        res.prod = (left.prod * right.prod) % K;
        for (int j = 0; j < K; j++) {
            res.remain[j] = left.remain[j];
        }
        for (int j = 0; j < K; j++) {
            int target = (left.prod * j) % K;
            res.remain[target] += right.remain[j];
        }
        return res;
    }
}
