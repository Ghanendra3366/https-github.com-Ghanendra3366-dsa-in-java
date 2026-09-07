public class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[26];
        long ans = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newAdded = (ans - dp[idx] + 1 + MOD) % MOD;
            ans = (ans + newAdded) % MOD;
            dp[idx] = (dp[idx] + newAdded) % MOD;
        }

        return (int) ans;
    }
}
