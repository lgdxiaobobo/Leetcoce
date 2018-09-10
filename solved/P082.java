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
        
        HashMap<Integer, Boolean> isExist = new HashMap<Integer, Boolean>();
        
        while(p != null){
            if (!isExist.containsKey(p.val)) isExist.put(p.val, false);
            else isExist.put(p.val, true);
            p = p.next;
        }
        
        ListNode q = new ListNode(head.val - 1);
        ListNode l = q;
        while(head != null){
            if (!isExist.get(head.val)){
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
        }
        return l.next;
    }
}
