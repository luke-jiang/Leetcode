/** Given the root node of a binary search tree, return the sum of values of all nodes
  * with value between L and R (inclusive).
  * The binary search tree is guaranteed to have unique values.
  * Example 1:
  *
  * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
  * Output: 32
  * Example 2:
  *
  * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
  * Output: 23
  *
  * Note:
  * The number of nodes in the tree is at most 10000.
  * The final answer is guaranteed to be less than 2^31.
  */

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high);
        }
    }
}
