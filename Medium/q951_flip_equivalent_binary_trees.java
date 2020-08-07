// [Tree]

/** For a binary tree T, we can define a flip operation as follows: choose any node,
  * and swap the left and right child subtrees.
  * A binary tree X is flip equivalent to a binary tree Y if and only if we can make
  * X equal to Y after some number of flip operations.
  * Write a function that determines whether two binary trees are flip equivalent.
  * The trees are given by root nodes root1 and root2.
  */

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        } else {
            boolean nonflip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            if (nonflip) {
                return true;
            } else {
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            }
        }
    }
}
