class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 0; i < k-1; i++) {
            first = first.next;
        }
        ListNode second = head;
        ListNode end = first;
        while (end.next != null) {
            second = second.next;
            end = end.next;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return head;
    }
}
