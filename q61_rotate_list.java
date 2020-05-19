// [LinkedList]

/** Given a linked list, rotate the list to the right by k places, where k is non-negative.
  * Examples:
  * Input: 1->2->3->4->5->NULL, k = 2
  * Output: 4->5->1->2->3->NULL
  * Input: 0->1->2->NULL, k = 4
  * Output: 2->0->1->NULL
  */

class Solution {
    // circular linked list
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode end = head;
        int len = 1;
        while (end.next != null) {
            len++;
            end = end.next;
        }

        k = k % len;
        if (k == 0) return head;

        end.next = head;

        ListNode prev = head;
        ListNode curr = head.next;
        for (int i = 0; i < len - k - 1; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }
}
