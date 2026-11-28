class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapest = Integer.MAX_VALUE;
        int maxFactor = 0;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            cheapest = Math.min(cheapest, item[1]);
        }
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        int[] multiples = new int[maxFactor + 1];
        for (int i = 1; i <= maxFactor; i++) {
            if (freq[i] > 0) {
                for (int j = i; j <= maxFactor; j += i) {
                    multiples[i] += freq[j];
                }
            }
        }
        List<long[]> deals = new ArrayList<>();
        for (int[] item : items) {
            int f = item[0];
            long p = item[1];
            int gain = multiples[f] - 1;
            if (gain > 0 && p < 2L * cheapest) {
                deals.add(new long[]{p, gain});
            }
        }
        deals.sort(Comparator.comparingLong(a -> a[0]));
        long total = 0;
        long rem = budget;
        for (long[] d : deals) {
            long p = d[0];
            long gain = d[1];
            long take = Math.min(gain, rem / p);
            total += 2 * take;
            rem -= take * p;
            if (take < gain) {
                break;
            }
        }
        total += rem / cheapest;
        return (int) total;
    }
}