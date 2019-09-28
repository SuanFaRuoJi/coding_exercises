class Solution:
    def lastRemaining(self, n: int) -> int:
        t = 0
        l = []
        while n != 1:
            l.append(n)
            n //= 2
            t += 1
        ans = 0
        while t != 0:
            if t % 2 == 1 or l[t - 1] % 2 == 1:
                ans += ans + 1
            else:
                ans += ans
            t -= 1
        return ans + 1
