class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2:
            return 0
        dp = [[0] * 2 for _ in range(len(prices))]
        dp[0][1] = -prices[0]
        ans = 0
        for i in range(1, len(prices)):
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        for i in range(1, len(prices)):
            dp[i][0] = prices[i] + dp[i - 1][1]
            dp[i][0] = max(dp[i][0], dp[i - 1][0])
            ans = max(ans, dp[i][0])
        if len(prices) < 4:
            return ans
        for i in range(len(prices)):
            dp[i][1] = 0
        dp[2][1] = dp[2][0] - prices[2]
        for i in range(3, len(prices)):
            dp[i][1] = max(dp[i - 1][1], dp[i][0]-prices[i])
        for i in range(3, len(prices)):
            dp[i][0] = prices[i] + dp[i - 1][1]
            ans = max(ans, dp[i][0])
        return ans
