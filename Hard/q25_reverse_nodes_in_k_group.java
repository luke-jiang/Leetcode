// [LinkedList]

/** Given a linked list, reverse the nodes of a linked list k at a time and return
  * its modified list.
  * k is a positive integer and is less than or equal to the length of the linked
  * list. If the number of nodes is not a multiple of k then left-out nodes in the
  * end should remain as it is.
  *
  * Example:
  * Given this linked list: 1->2->3->4->5
  * For k = 2, you should return: 2->1->4->3->5
  * For k = 3, you should return: 3->2->1->4->5
  *
  * Note:
  * Only constant extra memory is allowed.
  * You may not alter the values in the list's nodes, only nodes itself may be changed.
  */

class Solution {

    class ReverseList {
        ListNode head;
        ListNode end;

        public ReverseList() {
            head = null;
            end = null;
        }

        public ListNode add(ListNode n) {
            ListNode next = n.next;
            n.next = head;
            head = n;
            if (head.next == null) {
                end = head;
            }
            return next;
        }

        public Pair<ListNode, ListNode> getList() {
            Pair<ListNode, ListNode> res = new Pair<>(head, end);

            head = null;
            end = null;
            return res;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ReverseList rl = new ReverseList();
        int len = 0;
        for (ListNode n = head; n != null; n = n.next) {
            len++;
        }
        int t = len / k;

        ListNode res = new ListNode(-1);
        ListNode end = res;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < k; j++) {
                head = rl.add(head);
            }
            Pair<ListNode, ListNode> p = rl.getList();
            ListNode B = p.getKey();
            ListNode E = p.getValue();
            end.next = B;
            end = E;
        }
        end.next = head;
        return res.next;
    }
}
