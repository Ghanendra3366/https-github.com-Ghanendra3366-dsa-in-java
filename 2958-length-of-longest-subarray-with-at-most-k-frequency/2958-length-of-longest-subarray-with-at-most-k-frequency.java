class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res=0,start=-1;
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k){
                start++;
                map.put(nums[start],map.get(nums[start])-1);
            }
            res=Math.max(res,i-start);
        }
        return res;
    }
}