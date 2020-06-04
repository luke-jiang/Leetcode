class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode mid = head;
        ListNode end1 = head;

        while (end1 != end && end1.next != end) {
            mid = mid.next;
            end1 = end1.next.next;
        }

        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head, mid);
        root.right = buildTree(mid.next, end);

        return root;
    }
}

class Solution2 {
    // keep track of the current head of the list,
    // update the head once the left substree is built.
    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int len = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) len++;
        return buildTree(0, len-1);
    }

    private TreeNode buildTree(int from, int to) {
        if (from > to) return null;

        int mid = (from + to) / 2;

        TreeNode left = buildTree(from, mid-1);
        TreeNode root = new TreeNode(this.head.val);
        this.head = this.head.next;
        TreeNode right = buildTree(mid+1, to);

        root.left = left;
        root.right = right;

        return root;
    }
}
