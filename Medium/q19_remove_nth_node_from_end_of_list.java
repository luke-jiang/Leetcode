// [LinkedList, Stack]

/** Given a linked list, remove the n-th node from the end of list and return its head.
  * Example:
  * list =  1->2->3->4->5, n = 2, return  1->2->3->5
  */


class Solution {
    // two pointers, hard part is when n points to the head node.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode end = head;
        int i = 0;
        while (end != null && i < n) {
            end = end.next;
            i++;
        }

        if (end == null && i == n) return head.next;
        else if (end == null) return head;

        ListNode t = head;
        while (end.next != null) {
            t = t.next;
            end = end.next;
        }
        t.next = t.next.next;
        return head;
    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            s.push(curr);
        }
        for (int i = 0; i < n; i++) {
            s.pop();
        }
        if (s.isEmpty()) {
            return head.next;
        } else {
            ListNode prev = s.pop();
            prev.next = prev.next.next;
            return head;
        }
    }
}
