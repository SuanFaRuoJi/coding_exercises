public class jcy_lc121 {
    public int maxProfit(int[] prices) {
        int res = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}