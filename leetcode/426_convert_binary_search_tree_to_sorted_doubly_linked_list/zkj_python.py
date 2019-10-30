"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right
"""


class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        def dfs(root):
            if root.left is None:
                left = root
            else:
                left, r = dfs(root.left)
                r.right = root
                root.left = r
            if root.right is None:
                right = root
            else:
                l, right = dfs(root.right)
                l.left = root
                root.right = l
            return left, right
        if root is None:
            return None
        l, r = dfs(root)
        l.left = r
        r.right = l
        return l
