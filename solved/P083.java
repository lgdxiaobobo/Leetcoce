/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p = head;
        while(p.next != null){
            ListNode q = p.next;
            if (p.val < q.val) p = q;
            else p.next = q.next;
        }
        return head;
    }
}