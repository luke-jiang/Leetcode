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


/** Rationale
  * There are two kinds of path in a subtree rooted at node N:
  *     1) path that goes through n
  *     2) path that ends at n
  * The max path should be the maximum of 1) and 2). But observe that a path that goes through
  * n cannot be used to construct max path for its parent. Therefore, the helper function is designed
  * to return type 2) path, and we use a global `max` to keep track of maximum of type 1) path.
  * Suppose a subtree returns a negative type 2) path. We cannot select this negative path for constructing 
  * any type max path. So we max out the path with zero.
 */

class Solution {
    int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int lsum = Math.max(helper(node.left), 0);
        int rsum = Math.max(helper(node.right), 0);
        max = Math.max(max, node.val + lsum + rsum);
        return node.val + Math.max(lsum, rsum);
    }
}


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
