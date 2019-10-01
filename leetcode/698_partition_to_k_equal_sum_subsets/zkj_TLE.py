class Solution:
    def canPartitionKSubsets(self, nums, k):
        """
        time complexity: N * 2^N
        """
        if sum(nums) % k != 0:
            return False
        k_ = sum(nums) // k
        nums.sort()
        
        ans = [0, 1]
        num = (1<<len(nums))
        for i in range(2, num):
            ans.append(ans[i//2] + i % 2)
        d = list(range(num))
        d.sort(key=lambda x:ans[x])
        
        
        dp = [-1] * num
        dp[0] = 0
        a = 0
        for i in d:
            for k in range(len(nums)):
                if dp[i] != -1 and i & (1 << k) == 0:
                    t = dp[i] + nums[k]
                    if t <= k_:
                        dp[i + (1 << k)] = t % k_
                    a += 1
        return dp[-1] == 0
