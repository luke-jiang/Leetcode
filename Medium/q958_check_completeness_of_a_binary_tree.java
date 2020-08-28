// [Tree]

/** Given a binary tree, determine if it is a complete binary tree.
  * Definition of a complete binary tree from Wikipedia:
  * In a complete binary tree every level, except possibly the last, is completely
  * filled, and all nodes in the last level are as far left as possible. It can have
  * between 1 and 2h nodes inclusive at the last level h.
  *
  * Example 1:
  * Input: [1,2,3,4,5,6]
  * Output: true
  * Explanation: Every level before the last is full (ie. levels with node-values
  * {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as
  * possible.
  *
  * Example 2:
  * Input: [1,2,3,4,5,null,7]
  * Output: false
  * Explanation: The node with value 7 isn't as far left as possible.
  *
  * Note:
  * The tree will have between 1 and 100 nodes.
  */


class Solution {

    // Use the tree-array index property.
    // If the tree is a complete tree, the index of the last child is equal
    // to the number of nodes in tne tree.
    public boolean isCompleteTree(TreeNode root) {
        Map<TreeNode, Integer> code = new HashMap<>();
        code.put(root, 1);
        int maxcode = 1;
        int count = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            maxcode = Math.max(maxcode, code.get(n));
            if (n.left != null) {
                count++;
                int leftcode = code.get(n) * 2;
                code.put(n.left, leftcode);
                q.add(n.left);
            }
            if (n.right != null) {
                count++;
                int righttcode = code.get(n) * 2 + 1;
                code.put(n.right, righttcode);
                q.add(n.right);
            }
        }

        return maxcode == count;
    }
}
