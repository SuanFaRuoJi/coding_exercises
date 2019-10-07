class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not len(nums):
            return []
        queue = collections.deque()
        ans = []

        def add(queue, num):
            while len(queue) and queue[-1] < num:
                queue.pop()
            queue.append(num)

        for i in range(k - 1):
            add(queue, nums[i])

        for i in range(k - 1, len(nums)):
            add(queue, nums[i])
            ans.append(queue[0])
            if nums[i - k + 1] == queue[0]:
                queue.popleft()

        return ans
