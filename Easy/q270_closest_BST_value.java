// [Tree]

/** Given a non-empty binary search tree and a target value, find the value in the BST
  * that is closest to the target.
  *
  * Note:
  * Given target value is a floating point.
  * You are guaranteed to have only one unique value in the BST that is closest to the target.
  *
  * Example:
  * Input: root = [4,2,5,1,3], target = 3.714286

        4
       / \
      2   5
     / \
    1   3

  * Output: 4
  *
  */

class Solution {
    int res;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < Math.abs(res - target)) {
            res = root.val;
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }
}
