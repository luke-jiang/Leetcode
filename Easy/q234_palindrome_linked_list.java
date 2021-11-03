class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        for (ListNode n = head; n != null; n = n.next) st.push(n.val);
        ListNode n = head;
        while (!st.isEmpty()) {
            if (n.val != st.pop()) return false;
            n = n.next;
        }
        return true;
    }
}
