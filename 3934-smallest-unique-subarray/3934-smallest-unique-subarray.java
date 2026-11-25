class Solution {
    static final long M1 = 1_000_000_007L, M2 = 998_244_353L;
    long[] h1, h2, p1, p2;
    int n;
    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;
        long base = 100_003L + new Random().nextInt(1_000_000);
        h1 = new long[n + 1]; h2 = new long[n + 1];
        p1 = new long[n + 1]; p2 = new long[n + 1];
        p1[0] = 1; p2[0] = 1;
        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * base + nums[i]) % M1;
            h2[i + 1] = (h2[i] * base + nums[i]) % M2;
            p1[i + 1] = (p1[i] * base) % M1;
            p2[i + 1] = (p2[i] * base) % M2;
        }
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private boolean hasUnique(int len) {
        int m = n - len + 1;
        long[] hashes = new long[m];
        for (int i = 0; i < m; i++) {
            long x1 = (h1[i + len] - (h1[i] * p1[len]) % M1 + M1) % M1;
            long x2 = (h2[i + len] - (h2[i] * p2[len]) % M2 + M2) % M2;
            hashes[i] = (x1 << 32) | x2;
        }
        Arrays.sort(hashes);
        for (int i = 0; i < m; i++) {
            if ((i == 0 || hashes[i] != hashes[i - 1]) && (i == m - 1 || hashes[i] != hashes[i + 1])) return true;
        }
        return false;
    }
}
