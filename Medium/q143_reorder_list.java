// [LinkedList]

/** Given a singly linked list L: L0→L1→…→Ln-1→Ln,
  * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
  * You may not modify the values in the list's nodes, only nodes itself may be changed.
  */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        int len = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) len++;
        ListNode mid = head;
        for (int i = 0; i < (len / 2); i++) mid = mid.next;
        Stack<ListNode> stack = new Stack<>();

        while (mid.next != null) {
            stack.push(mid.next);
            mid.next = mid.next.next;
        }

        ListNode curr = head;
        while (!stack.isEmpty()) {
            ListNode to_insert = stack.pop();
            to_insert.next = curr.next;
            curr.next = to_insert;
            curr = to_insert.next;
        }
    }
}
