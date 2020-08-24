public class chengyou_lc309_dp {
    // Time complexity: O(N^2)
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 2];
        for (int i = prices.length - 1; i >= 0; i--) {
            int profit1 = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int curr = prices[j] - prices[i] + dp[j + 2];
                profit1 = Math.max(curr, profit1);
            }
            int profit2 = dp[i + 1];
            dp[i] = Math.max(profit1, profit2);
        }
        return dp[0];
    }
}
