public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                l++;
            } else if (ch == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        dfs(s, 0, l, r, res);
        return res;
    }

    private void dfs(String s, int start, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            char ch = s.charAt(i);
            if (ch == '(' && l > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, l - 1, r, res);
            }
            if (ch == ')' && r > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), i, l, r - 1, res);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
