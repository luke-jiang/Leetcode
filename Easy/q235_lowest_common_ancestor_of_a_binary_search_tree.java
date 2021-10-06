class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return helper(root, p, q);
        } else {
            return helper(root, q, p);
        }
    }
    
    private TreeNode helper(TreeNode root, TreeNode smaller, TreeNode larger) {
        if (root == null) return null;
        if (root.val == smaller.val || root.val == larger.val) return root;
        if (smaller.val < root.val && larger.val < root.val) {
            return helper(root.left, smaller, larger);
        } else if (smaller.val > root.val && larger.val > root.val) {
            return helper(root.right, smaller, larger);
        } else {
            return root;
        }
        
    }
}
