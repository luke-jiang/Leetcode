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


class Solution {
    // 08-23-21
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head; // for null head case
        // single for-loop to calculate list length and end node
        int len = 0;
        ListNode end = null;
        for (end = head; end.next != null; end = end.next) {
            len++;
        }
        len++;
        // for one-element case
        if (len <= 1) return head;
        // rotate ls by ls.length returns the original list
        k = k % len;
        // move `end` by `len-k` steps to the new end position
        end.next = head;
        for (int i = 0; i < len - k; i++) {
            end = end.next;
        }
        head = end.next;
        end.next = null;
        return head;
    }
}