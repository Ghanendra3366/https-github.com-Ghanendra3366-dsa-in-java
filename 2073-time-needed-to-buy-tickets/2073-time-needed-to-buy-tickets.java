class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n=tickets.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(i<=k){
                c+=Math.min(tickets[i],tickets[k]);
            }else{
                c+=Math.min(tickets[k]-1,tickets[i]);
            }
        }
        return c;
    }
}