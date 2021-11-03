class Solution {
    // recursive
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
    // iterative
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

class Solution {
    // using stack
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
