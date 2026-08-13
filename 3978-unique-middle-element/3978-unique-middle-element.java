class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length; 
        if(n == 1 )return true;
        int[] freq = new int[101];
        for(int num : nums){
            freq[num]++;
        }
        int idx = n /2;
        return freq[nums[idx]] == 1;
    }
}