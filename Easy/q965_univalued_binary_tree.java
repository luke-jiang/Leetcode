class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }
    
    private boolean helper(TreeNode root, int val) {
        if (root == null) return true;
        return root.val == val && helper(root.left, val) && helper(root.right, val);
    }
}
