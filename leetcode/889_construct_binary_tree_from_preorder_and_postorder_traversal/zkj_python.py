# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        def helper(pre: List[int], post: List[int]) -> TreeNode:
            root = TreeNode(pre.pop())
            if root.val == post[-1]:
                post.pop()
                return root
            root.left = helper(pre, post)
            if root.val == post[-1]:
                post.pop()
                return root
            root.right = helper(pre, post)
            post.pop()
            return root
        
        return helper(list(reversed(pre)), list(reversed(post)))
