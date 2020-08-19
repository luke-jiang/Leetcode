// [LinkedList]

/** Given a linked list and a value x, partition it such that all nodes less than x
  * come before nodes greater than or equal to x.
  * You should preserve the original relative order of the nodes in each of the two
  * partitions.
  *
  * Example:
  * Input: head = 1->4->3->2->5->2, x = 3
  * Output: 1->2->2->4->3->5
  */

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode sHead = new ListNode(-1);
        ListNode sEnd = sHead;
        ListNode gHead = new ListNode(-1);
        ListNode gEnd = gHead;

        while (head != null) {
            if (head.val < x) {
                sEnd.next = head;
                sEnd = sEnd.next;
            } else {
                gEnd.next = head;
                gEnd = gEnd.next;
            }
            head = head.next;
        }

        gEnd.next = null;
        sEnd.next = gHead.next;
        return sHead.next;
    }
}
