class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
        }
        
        double ans = powerHelper(x, N);
        
        if (n < 0) {
            return 1.0 / ans;
        }
        return ans;
    }

    private double powerHelper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double half = powerHelper(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
