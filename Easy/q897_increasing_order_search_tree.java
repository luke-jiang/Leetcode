class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        TreeNode end = dummy;
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        while (!st.isEmpty()) {
            TreeNode next = st.pop();
            TreeNode tmp = next.right;
            next.left = null; next.right = null;
            end.right = next;
            end = next;
            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }
        }
        return dummy.right;
    }
}
