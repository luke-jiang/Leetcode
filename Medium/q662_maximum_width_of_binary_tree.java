// [DFS] ***

/** Given a binary tree, write a function to get the maximum width of the given tree.
  * he maximum width of a tree is the maximum width among all levels.
  * The width of one level is defined as the length between the end-nodes (the leftmost
  * and right most non-null nodes in the level, where the null nodes between the end-nodes
  * are also counted into the length calculation.
  * It is guaranteed that the answer will in the range of 32-bit signed integer.
  *
  * Example 1:
  * Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

  * Output: 4
  * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
  *
  * Example 2:
  * Input:

          1
         /
        3
       / \
      5   3

  * Output: 2
  * Explanation: The maximum width existing in the third level with the length 2 (5,3).
  *
  * Example 3:
  * Input:

          1
         / \
        3   2
       /
      5

  * Output: 2
  * Explanation: The maximum width existing in the second level with the length 2 (3,2).
  *
  * Example 4:
  * Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
  * Output: 8
  * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,
  * null,null,null,null,null,7).
  *
  *
  */

class Solution {
    // use dfs-array indices to represent the tree:
    // if node n has index i, then its children have index 2*i and 2*i+1.

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList(), new ArrayList());
    }

    // order is the index of the root
    // start records the index of the leftmost (non-null) child node
    // end records the index of the rightmost child node
    private int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }

        // find width of the current level
        int curr = end.get(level) - start.get(level) + 1;

        // find max level
        int left = dfs(root.left, level+1, 2*order, start, end);
        int right = dfs(root.right, level+1, 2*order+1, start, end);
        return Math.max(curr, Math.max(left, right));
    }
}
