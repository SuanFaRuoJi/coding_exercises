def sumRange(nums, i: int, j: int) -> int:
    range_sum = 0

    i += len(nums) // 2
    j += len(nums) // 2
    while i <= j:
        if i & 1:
            range_sum += nums[i]
            i += 1
        i //= 2
        if not j & 1:
            range_sum += nums[j]
            j -= 1
        j //= 2
    return range_sum


def update_row(nums, i: int, val: int) -> None:
    nums[i] = val

    while i:
        nums[i >> 1] = nums[i] + nums[i ^ 1]
        i //= 2


class NumMatrix(object):

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        self.n = len(matrix)
        if not self.n:
            return
        self.m = len(matrix[0])
        self.tree = [[0] * 2 * self.m for _ in matrix] + \
            [[0] * self.m + i for i in matrix]
        for i in range(self.n * 2 - 1, -1, -1):
            for j in range(self.m - 1, -1, -1):
                self.tree[i][j] = self.tree[i][j * 2] + self.tree[i][j * 2 + 1]
        for i in range(self.n - 1, -1, -1):
            for j in range(2 * self.m):
                self.tree[i][j] = self.tree[i * 2][j] + self.tree[i * 2 + 1][j]

    def update(self, row, col, val):
        """
        :type row: int
        :type col: int
        :type val: int
        :rtype: None
        """
        i = row + self.n
        j = col + self.m
        update_row(self.tree[i], j, val)

        while i:
            update_row(self.tree[i >> 1], j, self.tree[i]
                       [j] + self.tree[i ^ 1][j])
            i //= 2

    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        ans = 0
        i = row1 + self.n
        j = row2 + self.n
        while i <= j:
            if i & 1:
                ans += sumRange(self.tree[i], col1, col2)
                i += 1
            i //= 2
            if not j & 1:
                ans += sumRange(self.tree[j], col1, col2)
                j -= 1
            j //= 2
        return ans


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
