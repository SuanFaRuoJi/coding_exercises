from collections import deque  # use it as a stack

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder: 
            return None
        
        root = TreeNode(preorder[0], None, None)
        stack = deque([root])
        ptr_pre = 1
        ptr_in = 0
        while stack: 
            while stack[-1].val != inorder[ptr_in]: 
                child = TreeNode(preorder[ptr_pre], None, None)
                ptr_pre += 1
                stack[-1].left = child
                stack.append(child)
            while stack and stack[-1].val == inorder[ptr_in]: 
                node = stack.pop()
                ptr_in += 1
            if ptr_in == len(inorder): 
                break
            child = TreeNode(preorder[ptr_pre], None, None)
            ptr_pre += 1
            node.right = child
            stack.append(child)
        return root
                
