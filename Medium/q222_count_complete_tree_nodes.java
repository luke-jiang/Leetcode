// [Tree]

/** Given a complete binary tree, count the number of nodes.
  * Note:
  * Definition of a complete binary tree from Wikipedia:
  * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
  * Example:
  * Input:
        1
       / \
      2   3
     / \  /
    4  5 6

  * Output: 6
  */


class Solution {
    // Use the property of complete tree. If a tree rooted at node n is a complete
    // tree, then at least one of its subtree is a perfect tree.
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // left-level and right-level of the left subtree.
        int LL = countLeft(root.left);
        int LR = countRight(root.left);

        if (LL == LR) {
            return 1 + get(LL) + countNodes(root.right);
        } else {
            return 1 + countNodes(root.left) + get(LL-1);
        }

    }

    // get returns how many nodes are there in a perfect tree of depth "level".
    private int get(int level) {
        int ans = 0;
        for (int i = 0; i < level; i++) {
            ans += Math.pow(2, i);
        }
        return ans;
    }

    private int countLeft(TreeNode root) {
        int ans = 0;
        for (TreeNode i = root; i != null; i = i.left) ans++;
        return ans;
    }

    private int countRight(TreeNode root) {
        int ans = 0;
        for (TreeNode i = root; i != null; i = i.right) ans++;
        return ans;
    }
}
