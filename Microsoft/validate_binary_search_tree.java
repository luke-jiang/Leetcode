class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        Integer prev = null;
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            if (prev != null && prev >= n.val) {
                return false;
            }
            prev = n.val;
            TreeNode tmp = n.right;
            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }
        }
        return true;
    }
}
