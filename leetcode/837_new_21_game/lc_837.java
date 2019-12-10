public class lc_837 {
    public double new21Game(int N, int K, int W) {
        double one_card = 1 / (double)W;
        if (K == 0) {
            return 1;
        }
        int width = K+W;
        if (width <= N) {
            return 1;
        }
        double prefix = 0;
        double[] dp = new double[width];
        int l = 1, r = 0;
        for (int i=1; i<width; i++) {
            if (i <= W) {
                dp[i] += one_card;
            }
            dp[i] += prefix * one_card;
            prefix += dp[i];
            r++;
            while(r-i+1 > W) {
                prefix -= dp[i];
                l++;
            }
        }
        double sum = 0;
        for (int i=K; i<=N; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
