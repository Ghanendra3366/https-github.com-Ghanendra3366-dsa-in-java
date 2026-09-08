class Solution {
    public int minCostToMoveChips(int[] position) {
        int even=0;
        int odd=0;
        int ans=0;
        for(int x:position){
            if(x%2==0){
                even++;
            }else{
                odd++;
            }
        }
        ans=Math.min(even,odd);
        return ans;
    }
}