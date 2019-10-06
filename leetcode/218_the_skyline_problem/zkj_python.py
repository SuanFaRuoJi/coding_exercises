def add(tree, i, h):
    i = len(tree) - 1 - i
    tree[i] = h
    while i > 0:
        i = (i - 1) >> 1
        tree[i] = max(tree[i], h)


def remove(tree, i):
    i = len(tree) - 1 - i
    tree[i] = 0

    while i > 0:
        i = (i - 1) >> 1
        t = 0 if 2 * i + 2 >= len(tree) else tree[2 * i + 2]
        tree[i] = max(tree[2 * i + 1], t)


class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        pts = set()
        for l, r, h in buildings:
            pts.add((l, h, -1))
            pts.add((r, h, l))
        pts = sorted(pts)
        x_to_i = {}
        for i, (x, h, s) in enumerate(pts):
            if s == -1:
                x_to_i[(x, h, -1)] = i

        t1 = 0
        t2 = len(pts)
        while t2 > 1:
            t1 += t2
            t2 = (t2 + 1) // 2
        tree = [0] * (t1 + 1)
        ans = []

        for i, (x, y, left_x) in enumerate(pts):
            if left_x == -1:
                t = tree[0]
                add(tree, i, y)
                if y > t:
                    ans.append([x, y])
            else:
                remove(tree, x_to_i[(left_x, y, -1)])
                t = tree[0]
                if t < y:
                    ans.append([x, t])
        ret = []
        for x, y in ans:
            if len(ret) and x == ret[-1][0]:
                ret[-1] = [x, y]
            else:
                ret.append([x, y])
        return ret
