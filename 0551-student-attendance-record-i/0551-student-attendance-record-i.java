class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                aCount++;
                if (aCount >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lCount++;
                if (lCount >= 3) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
