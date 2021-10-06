class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode next = head.next;
        
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> st = new Stack<>();
        for (ListNode n = head; n != null; n = n.next) {
            st.push(n);
        }
        head = st.pop();
        ListNode prev = head;
        while (!st.isEmpty()) {
            ListNode next = st.pop();
            prev.next = next;
            prev = next;
        }
        prev.next = null;
        return head;
        
    }
}
