class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        ans = 0
        if k > len(prices) // 2:
            for i in range(1, len(prices)):
                if prices[i] > prices[i - 1]:
                    ans += prices[i] - prices[i - 1]
            return ans
        cash = [0] * len(prices)
        for i in range(1, k + 1):
            if len(prices) < 2 * i:
                return ans
            s = cash[2 * (i - 1)] - prices[2 * (i - 1)]
            for j in range(2 * (i - 1) + 1, len(prices)):
                c = cash[j]
                cash[j] = max(prices[j] + s, cash[j - 1])
                s = max(s, c - prices[j])
            ans = cash[-1]
        return ans
