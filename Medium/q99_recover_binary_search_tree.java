/** You are given the root of a binary search tree (BST), where the values of exactly two nodes of the 
  * tree were swapped by mistake. Recover the tree without changing its structure.
  *
  * Input: root = [1,3,null,null,2]
  * Output: [3,1,null,null,2]
  * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
  *
  * Input: root = [3,1,4,null,null,2]
  * Output: [2,1,4,null,null,3]
  * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
  *
  */


/** Rationale
  * Traverse the tree in BST order using stack. Detect a pair of consecuting elements (i, j) where
  * i.val > j.val. If so, swap these two elements to restore order.
  * There can be two consecutive unordered pairs. E.g. for tree [3, null, 2, null, 1], we both have
  * (3 > 2) and (2 > 1). In this case, update j to store 1 instead of 2.
  * 
  */

class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode n = root;
        while (n != null) {
            st.push(n);
            n = n.left;
        }
        TreeNode fst = null;
        TreeNode snd = null;
        TreeNode prev = st.peek();

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            TreeNode tmp = curr.right;
            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }
            if (prev.val > curr.val) {
                if (fst == null) { 
                    // a pair is not found yet
                    fst = prev;
                }
                snd = curr; 
            }
            prev = curr;
        }
        // swap
        int tmp = fst.val;
        fst.val = snd.val;
        snd.val = tmp;
    }
}
