# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        def remove(node):
            if not node:
                ind = 0
            else:
                ind = remove(node.next) + 1
            if ind == n + 1:
                node.next = node.next.next
            return ind
        ind = remove(head)
        if ind == n:
            head = head.next
        return head