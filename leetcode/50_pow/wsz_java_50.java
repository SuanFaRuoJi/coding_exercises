class wsz_java_50 {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        double half = pow(x, n/2);
        if (n % 2 == 1) {
            return x * half * half;
        } else {
            return half * half;
        }
    }
}