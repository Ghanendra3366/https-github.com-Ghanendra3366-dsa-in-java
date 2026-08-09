class Solution {
    public long maxPairStrength(int[] nums) {
       int n=nums.length;
       long ans=0;
       for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            int g=gcd(nums[i],nums[j]);
            long max=((long)nums[i]*nums[j])/(g*g);
            ans=Math.max(ans,max);
        }
       }
       return ans;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}