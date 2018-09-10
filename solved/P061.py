# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None:
            return head
        N = 0
        p = head
        while p != None:
            p = p.next
            N += 1
        k = (N - k % N) % N
        if k == 0:
            return head
        else:
            p = head
            cnt  = k
            while p != None and cnt > 1:
                p = p.next
                cnt -= 1
            curr = p.next
            p.next = None
            p = curr
            while p.next != None:
                p = p.next
            p.next = head
            return curr
        