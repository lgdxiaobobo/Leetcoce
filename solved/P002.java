/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        
        int x = l1.val + l2.val;
        ListNode head = new ListNode(x % 10);
        ListNode  tmp = head;
        int     carry = x / 10; 
        
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            int value = l1.val + l2.val + carry;
            ListNode p = new ListNode(value % 10);
            tmp.next = p;
            carry = value / 10;
            tmp = tmp.next;
        }
        
        while (l1.next != null){
            l1 = l1.next;
            int value = l1.val + carry;
            ListNode p = new ListNode(value % 10);
            carry = value / 10;
            tmp.next = p;  
            tmp = tmp.next;
        }
        
        while (l2.next != null){
            l2 = l2.next;
            int value = l2.val + carry;
            ListNode p = new ListNode(value % 10);
            carry = value / 10;
            tmp.next = p;
            tmp = tmp.next;
        }
        
        if (carry > 0){
            ListNode p = new ListNode(carry);
            tmp.next = p;
            tmp = tmp.next;
        }
        return head;
    }
}