class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        long res = combination(n + k - 1, 2 * k, MOD);
        return (int) res;
    }
    private long combination(int n, int k, long mod) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n / k) k = n - k; 
        long num = 1, den = 1;
        for (int i = 0; i < k; i++) {
            num = (num * (n - i)) % mod;
            den = (den * (i + 1)) % mod;
        }
        return (num * power(den, mod - 2, mod)) % mod;
    }
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
