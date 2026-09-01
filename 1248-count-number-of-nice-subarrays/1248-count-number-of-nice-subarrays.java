class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int c = 0;
        int ind = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i : nums) {
            ind += i % 2;
            c += map.getOrDefault(ind - k, 0); 
            map.put(ind, map.getOrDefault(ind, 0) + 1);
        }
        return c;
    }
}
