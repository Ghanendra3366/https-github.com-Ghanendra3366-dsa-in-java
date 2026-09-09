class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, Integer> firstPos = new HashMap<>();
        Map<Integer, Integer> lastPos = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!firstPos.containsKey(x)) {
                firstPos.put(x, i);
            }
            lastPos.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        int specialCount = 0;
        for (int x : count.keySet()) {
            int totalOccurrences = count.get(x);
            int spanLength = lastPos.get(x) - firstPos.get(x) + 1;
            if (totalOccurrences == spanLength) {
                specialCount++;
            }
        }
        return specialCount;
    }
}