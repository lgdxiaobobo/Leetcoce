/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        else{
            ListNode curr = head;
            int cnt = 0;
            while(curr != null && cnt < k){
                cnt += 1;
                curr = curr.next;
            }
            if (cnt < k) return head;
            else{
                curr = reverseKGroup(curr, k);
                while(--cnt >= 0){
                    ListNode tmp = head.next;
                    head.next = curr;
                    curr = head;
                    head = tmp;
                }
                head = curr;
                return head;
            }
        }
    }
    
}