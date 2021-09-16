class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1.next != null && n2.next != null) {
            n1.val += n2.val;
            n1 = n1.next;
            n2 = n2.next;
        }
        n1.val += n2.val;
        if (n1.next == null) {
            n1.next = n2.next;
        }
        ListNode prev = l1;
        ListNode next = l1.next;
        while (prev != null) {
            if (prev.val >= 10) {
                if (next == null) {
                    next = new ListNode(0);
                    prev.next = next;
                }
                prev.val -= 10;
                next.val += 1;
            }
            prev = next;
            if (next != null) next = next.next;
        }
        return l1;
    }
}
