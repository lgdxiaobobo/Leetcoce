# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        countLeftHeight = lambda node: 1 + countLeftHeight(node.left) if node else 0
        countRightHeight = lambda node: 1 + countRightHeight(node.right) if node else 0
        left = countLeftHeight(root)
        right = countRightHeight(root)
        h = 2 ** right - 1
        if left == right:
            return h
        else:
            node = root
            while node:
                left = countLeftHeight(node.left)
                mid1 = countRightHeight(node.left)
                mid2 = countLeftHeight(node.right)
                right= countRightHeight(node.right)
                # print node.val, left, mid1, mid2, right
                if left > mid1:
                    node = node.left
                elif mid1 > mid2:
                    node = node.left
                    break
                elif mid2 == right:
                    break
                else:
                    h += 2 ** (left - 1)
                    node = node.right

            return h + 2 ** (countLeftHeight(node) - 1)
                