class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (right % 2 == 1) {
                    res++;
                    right--;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    res++;
                    right += 2;
                }
            }
        }

        return res + right;
    }
}
