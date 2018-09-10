# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return None
        bfs_seq = [(root, 0)]
        max_depth = 0
        leftmost  = root.val
        while len(bfs_seq) > 0:
            item = bfs_seq.pop(0)
            node = item[0]
            deep = item[1]
            if node.left:
                new_deep = deep + 1
                left_kid = node.left
                bfs_seq.append((left_kid, new_deep))
                if new_deep > max_depth:
                    max_depth = new_deep
                    leftmost = left_kid.val
            if node.right:
                new_deep = deep + 1
                right_kid= node.right
                bfs_seq.append((right_kid, new_deep))
                if new_deep > max_depth:
                    max_depth = new_deep
                    leftmost = right_kid.val                
        return leftmost        
                
                
                
                