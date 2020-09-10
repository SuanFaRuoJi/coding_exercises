public class wsz_956 {
    public int tallestBillboard(int[] rods) {
        int[] dp = new int[5001];
        for (int d = 1; d < 5001; d++) dp[d] = -10000;
        for (int x : rods) {
            int[] cur = dp.clone();
            for (int d = 0; d + x < 5001; d++) {
                dp[d + x] = Math.max(dp[d + x], cur[d]+x);
                dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.max(0, x-d));
            }
        }
        return dp[0];
    }
}
