class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;
        
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n / 2) {
                if (c == '?') {
                    leftQ++;
                } else {
                    leftSum += c - '0';
                }
            } else {
                if (c == '?') {
                    rightQ++;
                } else {
                    rightSum += c - '0';
                }
            }
        }
        
        int sumDiff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;
        
        if (sumDiff == (qDiff / 2.0) * 9) {
            return false;
        }
        
        return true;
    }
}
