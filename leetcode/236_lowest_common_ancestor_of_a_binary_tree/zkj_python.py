# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        self.ans = None
        
        def dfs(root):
            if root is None:
                return 0
            t = 0
            if root == p or root == q:
                t += 1
            t += dfs(root.left)
            t += dfs(root.right)
            if t == 2:
                self.ans = root
                return 0
            return t
        
        dfs(root)
        return self.ans
