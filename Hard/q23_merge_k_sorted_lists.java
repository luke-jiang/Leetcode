// [LinkedList, PriorityQueue] **

/** Given an array of linked-lists lists, each linked list is sorted in ascending order.
  * Merge all the linked-lists into one sort linked-list and return it.
  *
  * Example 1:
  * Input: lists = [[1,4,5],[1,3,4],[2,6]]
  * Output: [1,1,2,3,4,4,5,6]
  * Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
  * merging them into one sorted list:
  * 1->1->2->3->4->4->5->6
  */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode n : lists) {
            if (n != null) heap.add(n);
        }
        ListNode dummy = new ListNode(0);
        ListNode end = dummy;
        while (!heap.isEmpty()) {
            ListNode n = heap.poll();
            if (n.next != null) heap.add(n.next);
            end.next = n;
            end = end.next;
        }
        return dummy.next;
    }
}
