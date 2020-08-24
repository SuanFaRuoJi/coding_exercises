public class lc122_peak_valley {
    public int maxProfit(int[] prices) {
        int i = 0, valley = prices[0], peak = prices[0], maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i += 1;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i += 1;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}
