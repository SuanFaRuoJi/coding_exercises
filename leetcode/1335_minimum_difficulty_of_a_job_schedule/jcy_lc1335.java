public class jcy_lc1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < n; j++) dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
        for (int i = 1; i < d; i++) {
            for (int j = i; j < n; j++) {
                int curMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    curMax = Math.max(curMax, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + curMax);
                }
            }
        }
        return dp[d - 1][n - 1];
    }
}