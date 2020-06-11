
/** Given a binary tree, find its minimum depth. The minimum depth is the number of nodes
  * along the shortest path from the root node down to the nearest leaf node.
  * Note: A leaf is a node with no children.
  *
  * Example:
  * [3,9,20,null,null,15,7] -> 2
  */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        } else if (root.left == null) {
            return helper(root.right, depth+1);
        } else if (root.right == null) {
            return helper(root.left, depth+1);
        } else {
            return Math.min(helper(root.left, depth+1), helper(root.right, depth+1));
        }
    }
}
