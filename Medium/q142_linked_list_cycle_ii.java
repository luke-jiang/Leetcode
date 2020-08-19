// [Slow-Fast Pointer]

/** Given a linked list, return the node where the cycle begins. If there is no cycle,
  * return null.
  * To represent a cycle in the given linked list, we use an integer pos which represents
  * yhe position (0-indexed) in the linked list where tail connects to. If pos is -1, then
  * there is no cycle in the linked list.
  * Note: Do not modify the linked list.
  */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        boolean found = false;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                found = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (!found)  return null;

        // use the fact that the intersection of the head node and the fast cycle
        // is the cycle entry.
        fast = fast.next;

        ListNode i = head;
        while (i != fast) {
            i = i.next;
            fast = fast.next;
        }
        return fast;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        int cycle = 0;          // number of nodes in the cycle, if there is one.
        boolean found = false;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                found = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            cycle++;
        }

        if (!found)  return null;

        for (ListNode i = head; i != null; i = i.next) {
            ListNode k = i;
            // check if there is a cycle of size "cycle" starting at node k.
            for (int j = 0; j < cycle + 1; j++) k = k.next;
            if (i == k) return i;
        }

        return null;
    }
}
