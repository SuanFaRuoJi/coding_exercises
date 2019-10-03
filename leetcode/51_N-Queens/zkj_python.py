class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col = []
        diag = set()
        anti = set()

        ans = []

        def add(i, j):
            col.append(j)
            diag.add(i - j)
            anti.add(i + j)

        def remove(i, j):
            col.pop()
            diag.remove(i - j)
            anti.remove(i + j)

        def ok(i, j):
            return j not in col and i - j not in diag and i + j not in anti

        def dfs(i):
            if i == n:
                if len(col) == n:
                    t = []
                    for j in col:
                        t.append('.' * j + 'Q' + '.' * (n - j - 1))
                    ans.append(t)
                return
            for j in range(n):
                if ok(i, j):
                    add(i, j)
                    dfs(i + 1)
                    remove(i, j)

        dfs(0)
        return ans
