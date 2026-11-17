class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 1; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }
        int[][] cost = new int[n][n];
        int INF = 1000000;
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int minChanges = INF;
                for (int d : divisors[len]) {
                    int changes = 0;
                    for (int g = 0; g < d; g++) {
                        int left = i + g;
                        int right = j - d + g + 1;
                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }
                    minChanges = Math.min(minChanges, changes);
                }
                cost[i][j] = minChanges;
            }
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(k, i / 2); j++) {
                for (int p = (j - 1) * 2; p <= i - 2; p++) {
                    if (dp[p][j - 1] != INF && cost[p][i - 1] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost[p][i - 1]);
                    }
                }
            }
        }
        return dp[n][k];
    }
}
