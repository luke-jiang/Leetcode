class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        for (ListNode n = head; n != null; n = n.next) {
            map.put(n.val, map.getOrDefault(n.val, 0) + 1);
        }
        while (head != null && map.get(head.val) > 1) {
            head = head.next;
        }
        if (head == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (map.get(curr.val) == 1) {
                prev = prev.next;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return head;
    }
}
