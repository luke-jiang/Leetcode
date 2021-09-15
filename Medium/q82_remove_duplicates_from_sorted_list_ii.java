class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        head = dummy;
        
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            if (curr.next.val != curr.val) {
                prev = curr;
                curr = curr.next;
            } else {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        if (curr == null) {
            prev.next = null;
        }
        return head.next;
    }
}
