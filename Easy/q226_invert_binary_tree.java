class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
