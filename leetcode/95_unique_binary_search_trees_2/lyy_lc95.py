# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]: 
        if n < 1: 
            return []
        
        dp = [[[] for _ in range(n + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1): 
            dp[i][i].append(TreeNode(i, None, None))
        for step in range(1, n): 
            for i in range(1, n + 1 - step): 
                for l in dp[i][i+step-1]: 
                    root = TreeNode(i + step, l, None)
                    dp[i][i+step].append(root)
                for r in dp[i+1][i+step]: 
                    root = TreeNode(i, None, r)
                    dp[i][i+step].append(root)
                for val in range(i + 1, i + step): 
                    for l in dp[i][val-1]: 
                        for r in dp[val+1][i+step]: 
                            root = TreeNode(val, l, r)
                            dp[i][i+step].append(root)
        return dp[1][n]
        
