public class wsz_309 {
    public int maxProfit(int[] prices) {
        int[] stack = new int[prices.length], dp = new int[prices.length];
        int top = 0;
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            while (top != 0 && prices[stack[top-1]] > cur) {
                top--;
            }
            if (top != 0) {
                dp[i] = Math.max(dp[i], dp[stack[top-1]] + (cur - prices[stack[top-1]]));
                if (i + 2 < prices.length) {
                    dp[i+2] = Math.max(dp[i], dp[i+2]);
                }
            }
            stack[top++] = i;
        }
        return dp[prices.length-1];
    }
}
