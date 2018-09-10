# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def numComponents(self, head, G):
        """
        :type head: ListNode
        :type G: List[int]
        :rtype: int
        """
        
        g_set = set(G)
        cc_lst = []
        cur = head
        while cur != None:
            if cur.val in g_set:
                if len(cc_lst) == 0:
                    cc_lst.append(cur)
                elif cc_lst[-1].next.val != cur.val:
                    cc_lst.append(cur)
                else:
                    cc_lst[-1] = cur
            cur = cur.next
       
        return len(cc_lst)      


