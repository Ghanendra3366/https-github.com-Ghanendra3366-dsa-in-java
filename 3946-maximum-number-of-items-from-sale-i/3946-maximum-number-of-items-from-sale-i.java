class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int[] gain = new int[n];
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    count++;
                }
            }
            gain[i] = count;
        }
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int val = gain[i];
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + val);
            }
        }
        int maxTotal = 0;
        for (int b = 0; b <= budget; b++) {
            int remaining = budget - b;
            maxTotal = Math.max(maxTotal, dp[b] + (remaining / minPrice));
        }
        return maxTotal;
    }
}