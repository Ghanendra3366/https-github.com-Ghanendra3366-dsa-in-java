class Solution {
    private static final int MOD = 1_000_000_007;

    class LazySegmentTree {
        private int n;
        private long[] sum;
        private long[] sqSum;
        private long[] lazy;

        public LazySegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                int mid = (l + r) / 2;
                apply(2 * node, l, mid, lazy[node]);
                apply(2 * node + 1, mid + 1, r, lazy[node]);
                lazy[node] = 0;
            }
        }

        private void apply(int node, int l, int r, long val) {
            long len = r - l + 1;
            sqSum[node] = (sqSum[node] + 2 * val * sum[node] + val * val * len) % MOD;
            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        public void update(int node, int l, int r, int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }
            push(node, l, r);
            int mid = (l + r) / 2;
            if (ql <= mid) update(2 * node, l, mid, ql, qr, val);
            if (qr > mid) update(2 * node + 1, mid + 1, r, ql, qr, val);
            sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
            sqSum[node] = (sqSum[2 * node] + sqSum[2 * node + 1]) % MOD;
        }

        public long getSqSum() {
            return sqSum[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        LazySegmentTree tree = new LazySegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;
        long runningAns = 0;

        for (int r = 0; r < n; r++) {
            int l = lastSeen.getOrDefault(nums[r], -1) + 1;
            tree.update(1, 0, n - 1, l, r, 1);
            lastSeen.put(nums[r], r);
            runningAns = (runningAns + tree.getSqSum()) % MOD;
        }

        return (int) runningAns;
    }
}
