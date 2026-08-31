class Solution {
    public int findLucky(int[] arr) {
        int[]freq=new int[1001];
        for(int num:arr){
            freq[num]++;
        }
        int found=-1;
        for(int i=1;i<freq.length;i++){
            if(freq[i]==i){
                found=i;
            }
        }
        return found;
    }
}