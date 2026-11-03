class Solution {
    public int minMoves(int[] nums) {
        
        int d=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>d){
                d=nums[i];
            }
        }
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(d-num);
        }
        return moves;
    }
}