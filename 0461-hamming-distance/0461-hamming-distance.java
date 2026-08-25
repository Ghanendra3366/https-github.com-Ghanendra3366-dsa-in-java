class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;

        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }

        return count;
    }
}