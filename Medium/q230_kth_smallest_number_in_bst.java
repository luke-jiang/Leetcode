// [BST]

/** Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
  * Example 1:
  * Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
  * Output: 1
  *
  * Example 2:
  * Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
  * Output: 3
  */

class Solution {
    Map<TreeNode, Integer> leftCount;

    public int kthSmallest(TreeNode root, int k) {
        leftCount = new HashMap<>();
        count(root);
        return find(root, k);
    }

    private int find(TreeNode root, int k) {
        int lc = leftCount.getOrDefault(root, 0);
        if (lc + 1 == k) {
            return root.val;
        } else if (lc + 1 > k) {
            return find(root.left, k);
        } else {
            return find(root.right, k-1-lc);
        }
    }

    private int count(TreeNode root) {
        if (root == null) return 0;

        int l = count(root.left);
        int r = count(root.right);

        leftCount.put(root, l);

        return 1 + l + r;
    }
}
