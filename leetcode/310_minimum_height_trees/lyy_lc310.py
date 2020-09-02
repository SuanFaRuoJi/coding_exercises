from collections import deque  # use it as a queue

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        degrees = [0] * n
        leaves = deque()
        adj_list = [[] for _ in range(n)]
        for e in edges: 
            degrees[e[0]] += 1
            degrees[e[1]] += 1
            adj_list[e[0]].append(e[1])
            adj_list[e[1]].append(e[0])
        for i in range(n): 
            if degrees[i] == 1: 
                leaves.append(i)
        leaves.append(-1)
        
        cnt = n
        while cnt > 2: 
            while leaves[0] != -1: 
                leaf = leaves.popleft()
                degrees[leaf] = -1
                cnt -= 1
                for to in adj_list[leaf]: 
                    degrees[to] -= 1
                    if degrees[to] == 1: 
                        leaves.append(to)
            leaves.popleft()
            leaves.append(-1)
        
        ans = []
        for i in range(n): 
            if degrees[i] >= 0: 
                ans.append(i)
        return ans
                
