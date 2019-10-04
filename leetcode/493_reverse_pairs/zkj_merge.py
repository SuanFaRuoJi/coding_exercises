class Solution:
    def reversePairs(self, nums: List[int]) -> List[int]:
        self.ans = 0

        def merge(nums):
            if len(nums) <= 1:
                return nums
            mid = len(nums) // 2
            left = merge(nums[:mid])
            right = merge(nums[mid:])
            t = 0
            i = 0
            j = 0
            while i < len(left) and j < len(right):
                if left[i] > 2 * right[j]:
                    t += 1
                    j += 1
                else:
                    self.ans += t
                    i += 1
            while i < len(left):
                i += 1
                self.ans += t
            # black magic
            return sorted(left + right)

        merge(nums)
        return self.ans
