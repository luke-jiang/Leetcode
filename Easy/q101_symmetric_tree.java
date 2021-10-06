/** Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return isSymmetric(l.left, r.right) && isSymmetric(r.left, l.right);
    }
}
