# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        bfs_seq = [root]
        res = []
        while len(bfs_seq) > 0:
            res.append(max([x.val for x in bfs_seq]))
            bfs_seq = filter(lambda p: p, reduce(lambda a, b: a + b, [[x.left, x.right] for x in bfs_seq]))
        return res
                
                