class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        ListNode curr = head;
        while (i < left - 1) {
            i++;
            curr = curr.next;
        }
        while (i < right) {
            st.add(curr);
            q.add(curr.val);
            i++;
            curr = curr.next;
        }
        while (!st.isEmpty()) {
            ListNode n = st.pop();
            int val = q.remove();
            n.val = val;
        }
        return head;
    }
}
