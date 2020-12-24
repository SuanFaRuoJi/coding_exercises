public class jcy_lc122 {
    public int maxProfit(int[] prices) {
        int res = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] > minPrice) {
                res += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return res;
    }
}