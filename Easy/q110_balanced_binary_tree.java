// [Tree]

/** Given a binary tree, determine if it is height-balanced.
  * For this problem, a height-balanced binary tree is defined as:
  * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
  */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) &&
            Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return depth(root) > 0;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int hleft = depth(root.left);
        int hright = depth(root.right);
        if (hleft == -1 || hright == -1 || Math.abs(hleft - hright) > 1) {
            return -1;
        }
        return 1 + Math.max(hleft, hright);
    }
}
