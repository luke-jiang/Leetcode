// [LinkedList]

/** Remove all elements from a linked list of integers that have value val.
  * Example:
  * Input:  1->2->6->3->4->5->6, val = 6
  * Output: 1->2->3->4->5
  */
  
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;

        while (prev != null && curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
            } else {
                prev = prev.next;
            }
            if (prev != null) curr = prev.next;

        }

        return head.val == val ? head.next : head;
    }
}
