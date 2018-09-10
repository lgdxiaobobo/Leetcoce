# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        def transform(x):
            if x:
                if x.left and x.right:
                    transform(x.left)
                    transform(x.right)
                    right_x = x.right
                    left_x = x.left
                    x.left = None
                    x.right = left_x
                    curr = left_x
                    while curr.right:
                        curr = curr.right
                    curr.right = right_x
                elif x.left:
                    transform(x.left)
                    left_x = x.left
                    x.left = None
                    x.right = left_x
                elif x.right:
                    transform(x.right)
        transform(root)
                    

            