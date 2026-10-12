class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }
        long totalSumOfSquares = 0;
        int modulo = 1_000_000_007;
        for (int i = 0; i < k; i++) {
            long currentNumber = 0;
            for (int j = 0; j < 31; j++) {
                if (bitCounts[j] > 0) {
                    currentNumber |= (1L << j);
                    bitCounts[j]--;
                }
            }
            totalSumOfSquares = (totalSumOfSquares + (currentNumber * currentNumber) % modulo) % modulo;
        }
        return (int) totalSumOfSquares;
    }
}
