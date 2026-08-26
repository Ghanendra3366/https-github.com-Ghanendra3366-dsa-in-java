class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int ans = r;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            long hours = 0;

            for (int pile : piles) {
               hours += Math.ceil((double) pile / mid);

            }

            if (hours <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}