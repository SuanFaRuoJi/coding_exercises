class Solution:
    def reversePairs(self, nums: List[int]) -> int:

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

        t = list(set([2 * i for i in nums] + nums))
        v_to_i = {}
        for i, v in enumerate(sorted(t)):
            v_to_i[v] = i
        BIT = [0] * (len(t) + 1)

        t = 0
        for i in nums:
            t += query(BIT, len(BIT) - 1) - query(BIT, v_to_i[2 * i] + 1)
            add(BIT, v_to_i[i] + 1)
        return t
