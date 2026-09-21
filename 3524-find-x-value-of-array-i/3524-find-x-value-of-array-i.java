class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;
            newDp[numMod]++;
            
            for (int r = 0; r < k; ++r) {
                if (dp[r] > 0) {
                    int newMod = (int) (1L * r * numMod % k);
                    newDp[newMod] += dp[r];
                }
            }
            for (int r = 0; r < k; ++r) {
                ans[r] += newDp[r];
            }
            dp = newDp;
        }
        return ans;
    }
}
