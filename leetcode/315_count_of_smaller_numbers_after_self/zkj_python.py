class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        self.ans = [0] * len(nums)
        nums = list(enumerate(nums))
        from collections import deque

        def merge(nums):
            nums = list(nums)
            if len(nums) <= 1:
                return deque(nums)
            arr = deque([])
            mid = len(nums) // 2
            left = merge(nums[:mid])
            right = merge(nums[mid:])
            t = 0
            while len(left) and len(right):
                min_left_i, min_left_ele = left[0]
                min_right_i, min_right_ele = right[0]
                if min_left_ele > min_right_ele:
                    t += 1
                    arr.append(right.popleft())
                else:
                    self.ans[min_left_i] += t
                    arr.append(left.popleft())
            while len(left):
                min_left_i, min_left_ele = left.popleft()
                self.ans[min_left_i] += t
                arr.append((min_left_i, min_left_ele))
            arr += right
            return arr

        merge(deque(nums))
        return self.ans
