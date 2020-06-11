// [Tree, BFS]

/** Given a binary tree, imagine yourself standing on the right side of it,
  * return the values of the nodes you can see ordered from top to bottom.
  *
  * Example:
  * [1,2,3,null,5,null,4] -> [1, 3, 4]
  * [1,2,3,null,5] -> [1, 3, 5]
  */

class Solution {
    // BFS while keeps track of the last node for each layer
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                if (i == size-1) {
                    res.add(curr.val);
                }
            }
        }
        return res;
    }
}
