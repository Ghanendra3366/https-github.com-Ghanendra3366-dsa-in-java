class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (first[charIdx] == -1) first[charIdx] = i;
            last[charIdx] = i;
        }
        List<int[]> validIntervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (i == first[charIdx]) {
                int left = first[charIdx];
                int right = last[charIdx];
                boolean isValid = true;
                for (int j = left; j <= right; j++) {
                    int currChar = s.charAt(j) - 'a';
                    if (first[currChar] < left) {
                        isValid = false;
                        break;
                    }
                    right = Math.max(right, last[currChar]);
                }
                if (isValid) validIntervals.add(new int[]{left, right});
            }
        }
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int lastEnd = -1;
        for (int[] interval : validIntervals) {
            int l = interval[0];
            int r = interval[1];
            if (l > lastEnd) {
                result.add(s.substring(l, r + 1));
                lastEnd = r;
            }
        }
        return result;
    }
}
