class Solution {
    public boolean canAliceWin(int n) {
        if (n < 10) {
            return false;
        }
        n -= 10;
        int stones = 9;
        boolean alice = false;
        while (n >= stones) {
            n -= stones;
            stones--;
            alice = !alice;
        }
        return !alice;
    }
}
