// [DFS]

/** Given a binary tree, count the number of uni-value subtrees.
  * A Uni-value subtree means all nodes of the subtree have the same value.
  *
  * Example :
  * Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

  * Output: 4
  *
  */

class Solution {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftunival = dfs(root.left);
        boolean rightunival = dfs(root.right);
        if (!leftunival || !rightunival) {
            return false;
        }
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        count++;
        return true;
    }
}
