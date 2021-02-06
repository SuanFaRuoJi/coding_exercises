public class jcy_lc276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        else if (n == 1) return k;
        else if (n == 2) return k * k;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = k; dp[2] = k * k;
        for (int i = 3; i < n + 1; i++) dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        return dp[n];
    }
}