class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int give = 1;
        int i = 0;

        while (candies > 0) {
            int x = Math.min(candies, give);

            ans[i % num_people] += x;

            candies -= x;
            give++;
            i++;
        }

        return ans;
    }
}