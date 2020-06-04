// [BFS]

/** Given a binary tree, return the level order traversal of its nodes' values.
  * (ie, from left to right, level by level).
  *
  * For example:
  * Given binary tree [3,9,20,null,null,15,7],
  * return its level order traversal as:
  * [[3],[9,20],[15,7]]
  */

class Solution {
    // takeaway: use queue.size() and for-loop to conduct BFS with level-awareness.
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                subList.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(subList);
        }

        return res;
    }
}
