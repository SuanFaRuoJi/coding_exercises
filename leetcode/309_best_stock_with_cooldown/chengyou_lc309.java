public class chengyou_lc309 {
    // Time complexity: O(N)
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;
        for (int i = 0; i < prices.length; i++) {
            int preSold = sold;
            sold = held + prices[i];
            held = Math.max(held, reset - prices[i]);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }
}
