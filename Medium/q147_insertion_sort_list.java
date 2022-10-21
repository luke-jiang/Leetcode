class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode arr = new ListNode();
        ListNode n = head;
        while (n != null) {
            ListNode prev = arr;
            while (prev.next != null && prev.next.val < n.val) prev = prev.next;
            ListNode next = n.next;
            n.next = prev.next;
            prev.next = n;
            n = next;
        }
        return arr.next;
    }
}
