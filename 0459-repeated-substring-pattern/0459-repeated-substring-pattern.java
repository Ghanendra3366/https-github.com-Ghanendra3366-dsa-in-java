class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }
            String sub = s.substring(0, len);
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n / len; j++) {
                str.append(sub);
            }
            if (str.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}