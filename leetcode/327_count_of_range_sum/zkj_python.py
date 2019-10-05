class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        def lowbit(i):
            return i & (i ^ (i-1))

        def add(BIT, i):
            while i < len(BIT):
                BIT[i] += 1
                i += lowbit(i + 1)

        def query(BIT, i):
            sum = 0
            while i > 0:
                sum += BIT[i]
                i -= lowbit(i + 1)
            return sum

        if not len(nums):
            return 0
        prefix = [0]
        for i in nums:
            prefix.append(prefix[-1] + i)

        t = list(set([i - lower for i in prefix] +
                     prefix + [i - upper for i in prefix]))
        v_to_i = {}
        for i, v in enumerate(sorted(t)):
            v_to_i[v] = i
        BIT = [0] * (len(t) + 1)

        t = 0
        for i in prefix:
            t += query(BIT, v_to_i[i - lower] + 1) - \
                query(BIT, v_to_i[i - upper])
            add(BIT, v_to_i[i] + 1)

        return t
