class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> k = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            k.put(nums[i],k.getOrDefault(nums[i],0)+1);
        }
        int x = nums.length / 2 ;  int cnt = 0 ;
        for(int f : k.keySet()){
            if(k.get(f)%2!=0){
              return false;
            }
        }

        return true;
    }
}