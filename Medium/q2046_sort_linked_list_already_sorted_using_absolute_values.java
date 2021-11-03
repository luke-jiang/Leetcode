class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode negHead = null;
        ListNode negTail = null;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < 0) {
                prev.next = curr.next;
                curr.next = null;
                if (negHead == null) {
                    negHead = curr;
                    negTail = curr;
                } else {
                    curr.next = negHead;
                    negHead = curr;
                }
                curr = prev.next;
            } else {
                prev = prev.next;
                curr = prev.next;
            }
        }
        if (negHead == null) return head;
        negTail.next = head;
        return negHead;
    }
}
