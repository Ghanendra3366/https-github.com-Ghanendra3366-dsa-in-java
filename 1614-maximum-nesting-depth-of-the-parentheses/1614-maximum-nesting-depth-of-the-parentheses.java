class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                maxDepth = Math.max(maxDepth, ++currentDepth);
            } else if (ch == ')') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
}
