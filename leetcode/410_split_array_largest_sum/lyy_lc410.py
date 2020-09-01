class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][0] = nums[0]
        for j in range(1, n): 
            dp[0][j] = dp[0][j-1] + nums[j]
        for i in range(1, m): 
            acc = 0
            curr = n - 1
            for j in range(n - 1, i - 1, -1): 
                if j < n - 1: 
                    acc -= nums[j+1]
                if curr == j: 
                    acc += nums[j]
                    curr -= 1
                while curr >= i: 
                    if max(dp[i-1][curr-1], acc + nums[curr]) <= max(dp[i-1][curr], acc): 
                        acc += nums[curr]
                        curr -= 1
                    else: 
                        break
                dp[i][j] = max(dp[i-1][curr], acc)
        return dp[-1][-1]
