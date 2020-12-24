public class jcy_lc123_dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int leftMin = prices[0], rightMax = prices[n - 1];
        int[] left = new int[n], right = new int[n + 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
            int j = n - i - 1;
            right[j] = Math.max(right[j + 1], rightMax - prices[j]);
            rightMax = Math.max(rightMax, prices[j]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++)
            maxProfit = Math.max(maxProfit, left[i] + right[i + 1]);
        return maxProfit;
    }
}