// [Tree]

/** Given the root of a binary tree with N nodes, each node in the tree has node.val coins,
  * and there are N coins total.
  * In one move, we may choose two adjacent nodes and move one coin from one node to another.
  * (The move may be from parent to child, or from child to parent.)
  *
  * Return the number of moves required to make every node have exactly one coin.
  */

class Solution {
    int totalmove = 0;

    public int distributeCoins(TreeNode root) {
        if (root != null) {
            giveCount(root, null);
        }
        return totalmove;
    }

    private void giveCount(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        giveCount(root.left, root);
        giveCount(root.right, root);
        if (parent != null) {
            if (root.val > 0) {
                int move = root.val - 1;
                parent.val += move;
                totalmove += move;
            } else if (root.val <= 0) {
                int move = 0 - root.val + 1;
                parent.val -= move;
                totalmove += move;
            }
        }
    }
}
