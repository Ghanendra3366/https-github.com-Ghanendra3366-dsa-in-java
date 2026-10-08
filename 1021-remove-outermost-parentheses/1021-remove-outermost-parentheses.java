class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int l = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (l > 0) {
                    res.append(c);
                }
                l++;
            } else {
                l--;
                if (l > 0) {
                    res.append(c);
                }
            }
        }
        
        return res.toString();
    }
}
