class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int n = prices.length;
        int m = discounts.length;

        double total = 0.0;
        int k = Math.min(n, m);

        for (int i = 0; i < k; i++) {
            int price = prices[n - 1 - i];
            int discount = discounts[m - 1 - i];

            total += price * (100.0 - discount) / 100.0;
        }
        for (int i = 0; i < n - k; i++) {
            total += prices[i];
        }

        return total;
    }
}