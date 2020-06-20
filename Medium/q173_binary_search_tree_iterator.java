// [BST, Stack] ***

/** Implement an iterator over a binary search tree (BST). Your iterator will be initialized
  * with the root node of a BST.
  * Calling next() will return the next smallest number in the BST.
  *
  * Example:
  * root = [7, 3, 15, null, null, 9, 20]
  * calling next() returns the following sequence: [3,7,9,15,20]
  *
  * Note:
  * next() and hasNext() should run in average O(1) time and uses O(h) memory,
  *   where h is the height of the tree.
  * You may assume that next() call will always be valid, that is, there will be
  *  at least a next smallest number in the BST when next() is called.
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            s.push(curr);
            curr = curr.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = s.pop();
        int ans = next.val;
        if (next.right != null) {
            next = next.right;
            while (next != null) {
                s.push(next);
                next = next.left;
            }
        }
        return ans;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
