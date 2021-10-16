
/** You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number 
  * starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, 
  * which is 13.
  * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
  * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
  */

class Solution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        search(root, 0);
        return sum;
    }
    
    private void search(TreeNode root, int curr) {
        if (root == null) return;
        curr = (curr << 1) | root.val;
        if (root.left == null && root.right == null) {
            sum += curr;
        } else {
            search(root.left, curr);
            search(root.right, curr);
        }
    }
}
