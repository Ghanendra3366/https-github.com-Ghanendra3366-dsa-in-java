class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        
        int maxDiff = 0;
        long totalDiffSum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            totalDiffSum += diff;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        if (totalDiffSum <= k) {
            return 0;
        }
        
        int[] buckets = new int[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            buckets[Math.abs(nums1[i] - nums2[i])]++;
        }
        
        for (int d = maxDiff; d > 0; d--) {
            if (buckets[d] > 0) {
                if (k >= buckets[d]) {
                    k -= buckets[d];
                    buckets[d - 1] += buckets[d];
                    buckets[d] = 0;
                } else {
                    buckets[d - 1] += k;
                    buckets[d] -= (int) k;
                    k = 0;
                    break;
                }
            }
        }
        
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (buckets[d] > 0) {
                minSumSquare += (long) d * d * buckets[d];
            }
        }
        
        return minSumSquare;
    }
}
