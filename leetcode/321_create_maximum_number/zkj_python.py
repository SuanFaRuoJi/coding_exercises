class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        def merge(n1, n2):
            t = []
            i, j = 0, 0
            while i != len(n1) or j != len(n2):
                t1 = i
                t2 = j
                while t1 < len(n1) and t2 < len(n2) and n1[t1] == n2[t2]:
                    t1 += 1
                    t2 += 1
                if t1 == len(n1) or (t2 < len(n2) and n1[t1] < n2[t2]):
                    t.append(n2[j])
                    j += 1
                else:
                    t.append(n1[i])
                    i += 1
            return tuple(t)

        def maximum(nums, k):
            ans = []
            cand_nums = [[[]] * (len(nums) + 1) for _ in range(k + 1)]
            for i in range(1, k + 1):
                t = []
                for j in range(len(nums) - i, -1, -1):
                    if len(t) == 0 or cand_nums[i - 1][j + 1][0] >= t[0]:
                        t = cand_nums[i - 1][j + 1]
                    cand_nums[i][j] = [nums[j]] + t
            ans = [max(map(tuple, i)) for i in cand_nums]
            return ans

        if k == len(nums1) + len(nums2):
            return merge(nums1, nums2)
        ans = tuple([0] * k)
        cand_nums1 = maximum(nums1, min(k, len(nums1)))
        cand_nums2 = maximum(nums2, min(k, len(nums2)))

        if len(nums1) == 0:
            return list(cand_nums2[k])
        if len(nums2) == 0:
            return list(cand_nums1[k])

        for i in range(k + 1):
            j = k - i
            if i >= len(cand_nums1) or j >= len(cand_nums2):
                continue
            t = merge(cand_nums1[i], cand_nums2[j])
            ans = max(ans, t)
        return list(ans)
