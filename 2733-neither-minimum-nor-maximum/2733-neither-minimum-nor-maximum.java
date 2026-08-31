class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        for(int x:nums){
            if(x<max && x>min){
                return x;
            }
        }
        return -1;
    }
}