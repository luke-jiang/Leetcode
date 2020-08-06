/** Given a non-empty binary tree, find the maximum path sum.
  * For this problem, a path is defined as any sequence of nodes from some starting
  * node to any node in the tree along the parent-child connections. The path must
  * contain at least one node and does not need to go through the root.
  *
  * Example 1:
  * Input: [1,2,3]

       1
      / \
     2   3

  * Output: 6
  *
  * Example 2:
  * Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

  * Output: 42
  *
  */

// let maxgain(node) be the maximum contribution that this node and one/zero
// of its subtrees could add.


class Solution {
    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxgain(root);
        return max_sum;
    }

    public int maxgain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // max sum on the left and right subtrees.
        // choose 0 if the maxgain is negative. That is, discard potential paths
        // in the subtree.
        int left_gain = Math.max(maxgain(node.left), 0);
        int right_gain = Math.max(maxgain(node.right), 0);

        // the price to start a new path where "node" is the highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update global max_sum
        max_sum = Math.max(max_sum, price_newpath);

        // return the max_gain
        return node.val + Math.max(left_gain, right_gain);
    }
}
