class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        nums = list(reversed(nums))
        index = list(range(len(nums) - 1, -1, -1))
        index.sort(key=lambda x: nums[x])
        BIT = [0] * len(nums)
        ans = [0] * len(nums)

        def lowbit(i):
            return i & (i ^ (i-1))

        def update(BIT, i, delta):
            while i < len(BIT):
                BIT[i] += delta
                i += lowbit(i + 1)

        def query(BIT, i):
            sum = 0
            while i > 0:
                sum += BIT[i]
                i -= lowbit(i + 1)
            return sum

        for i in index:
            ans[i] = query(BIT, i)
            update(BIT, i, 1)

        return list(reversed(ans))
