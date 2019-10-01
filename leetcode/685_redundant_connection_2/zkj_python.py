class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        from collections import Counter, defaultdict, deque
        out_degree = Counter()
        two_parent = []
        possible_cycle = set()
        parent = defaultdict(list)
        for i, j in edges:
            possible_cycle.add(i)
            possible_cycle.add(j)
            parent[j].append(i)
            out_degree[i] += 1

        for i in parent:
            if len(parent[i]) == 2:
                for j in parent[i]:
                    two_parent.append([j, i])

        cur = deque([i for i in possible_cycle if i not in out_degree])
        while cur:
            t = cur.popleft()
            possible_cycle.remove(t)
            for i in parent[t]:
                out_degree[i] -= 1
                if out_degree[i] == 0:
                    cur.append(i)

        if len(two_parent) == 0:
            for i, j in reversed(edges):
                if i in possible_cycle and j in possible_cycle:
                    return [i, j]
        elif len(possible_cycle) == 0:
            return two_parent[1]
        else:
            t = two_parent[0][0]
            while t in parent:
                t = parent[t][0]
                if t == two_parent[0][1]:
                    return two_parent[0]
            return two_parent[1]
