class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int diff=0;
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i<j){
                    diff=nums[j]-nums[i];
                    if(diff>0)
                    max=Math.max(max,diff);
                }
            }
        }
        return max;
    }
}