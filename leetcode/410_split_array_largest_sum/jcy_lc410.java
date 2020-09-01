public class jcy_lc410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m + 1][n + 1];
        int[] P = new int[n + 1];
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                dp[i][j] = Integer.MAX_VALUE;
        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i++)
            P[i] = P[i - 1] + nums[i - 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 0; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], P[j] - P[k]));
        return dp[m][n];
    }
}