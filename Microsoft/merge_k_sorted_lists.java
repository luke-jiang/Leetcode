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
