# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pruneTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """

        def dfs(node):
            if not node.left and not node.right:
                if node.val == 0:
                    return False
                else:
                    return True
            else:
                left = dfs(node.left) if node.left else False
                right = dfs(node.right) if node.right else False
                state = left or right or node.val == 1
            
                if node.left and not left:
                    node.left = None
                if node.right and not right:
                    node.right = None
                return state

        if not root.left and not root.right:
            if root.val == 1:
                return root
            else:
                return None
        else:
            curr = root
            if not dfs(curr):
                curr = None
            return curr