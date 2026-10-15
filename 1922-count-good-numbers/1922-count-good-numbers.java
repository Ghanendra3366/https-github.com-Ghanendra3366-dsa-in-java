class Solution {
    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long waysEven = power(5, evenCount);
        long waysOdd = power(4, oddCount);

        return (int) ((waysEven * waysOdd) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = power(base, exp / 2);
        long halfSquared = (half * half) % MOD;

        if (exp % 2 == 1) {
            return (halfSquared * base) % MOD;
        }

        return halfSquared;
    }
}
