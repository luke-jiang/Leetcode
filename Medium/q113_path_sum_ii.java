// [DFS]

/** Given a binary tree and a sum, find all root-to-leaf paths where each path's
  * sum equals the given sum.
  * Note: A leaf is a node with no children.
  * Example:
  * Input: [5,4,8,11,null,13,4,7,2,null,null,5,1], sum = 22
  * Output: [[5,4,11,2], [5,8,4,5]]
  */

  // Note: sum and root values can be negative.

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            dfs(root, sum, path);
        }
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, sum, path);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, sum, path);
            path.remove(path.size()-1);
        }
    }
}
