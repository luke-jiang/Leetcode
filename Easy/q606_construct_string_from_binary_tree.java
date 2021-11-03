class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        helper(root);
        return sb.toString();
    }
    private void helper(TreeNode root) {
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            helper(root.left);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) sb.append("()");
            sb.append("(");
            helper(root.right);
            sb.append(")");
        }
    }
}
