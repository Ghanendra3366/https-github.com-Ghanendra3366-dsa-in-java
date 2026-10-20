class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }

        for (int k : divisors) {
            if (isValid(nums, n, k)) {
                ans += k;
            }
        }

        return ans;
    }

    private boolean isValid(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int end = start + k;
            int drops = 0;
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;

            for (int i = start; i < end; i++) {
                currentMin = Math.min(currentMin, nums[i]);
                currentMax = Math.max(currentMax, nums[i]);

                if (i < end - 1 && nums[i] > nums[i + 1]) {
                    drops++;
                }
            }

            if (nums[end - 1] > nums[start]) {
                drops++;
            }

            if (drops > 1) {
                return false;
            }

            if (currentMin < prevMax) {
                return false;
            }

            prevMax = currentMax;
        }

        return true;
    }
}