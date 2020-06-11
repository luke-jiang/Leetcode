// [BFS]
/** Given a binary tree, return the zigzag level order traversal of its nodes' values.
  * (ie, from left to right, then right to left for the next level and alternate between).
  * For example:
  * Given binary tree [3,9,20,null,null,15,7],
  * return its zigzag level order traversal as:
  * [[3], [20,9], [15,7]]
  */

class Solution {
    // Essentially BFS, but either prepend or append a new value to
    // the level list based on which level it is at.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (res.size() % 2 == 0) {
                    level.add(node.val);
                } else{
                    level.add(0, node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
