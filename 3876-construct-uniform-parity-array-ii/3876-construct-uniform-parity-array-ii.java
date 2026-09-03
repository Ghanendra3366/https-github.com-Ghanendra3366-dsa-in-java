class Solution {
    public boolean uniformArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
        }
        if (min%2==0) {
            for (int x : nums) {
                if (x%2!=0) {
                    boolean possible = false;
                    for (int y : nums) {
                        if (y<x && y%2!=0) {
                            possible = true;
                            break;
                        }
                    }
                    if(!possible) return false;
                }
            }
        }
        return true;
    }
}
