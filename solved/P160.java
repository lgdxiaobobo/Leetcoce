/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int sizeList(ListNode head){
        int len = 0;
        while (head != null){
            len += 1;
            head = head.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        else{
            int lenA = sizeList(headA);
            int lenB = sizeList(headB);
            while (lenA > lenB) {lenA -= 1; headA = headA.next;}
            while (lenA < lenB) {lenB -= 1; headB = headB.next;}
            while(headA != null && headB != null && headA.val != headB.val){
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }
}