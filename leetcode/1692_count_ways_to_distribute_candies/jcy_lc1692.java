public class jcy_lc1692 {
    public int waysToDistribute(int n, int k) {
        long mod = 1000000007;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i < k + 1; i++) dp[i][i] = 1;
        for (int i = 1; i < k + 1; i++)
            for (int j = i + 1; j < n + 1; j++)
                dp[i][j] = (dp[i - 1][j - 1] + i * dp[i][j - 1]) % mod;
        return (int)dp[k][n];
    }
}