// [BST, Preorder Traversal]

/** Return the root node of a binary search tree that matches the given preorder traversal.
  * (Recall that a binary search tree is a binary tree where for every node, any descendant
  * of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
  * Also recall that a preorder traversal displays the value of the node first, then traverses
  * node.left, then traverses node.right.)
  *
  * It's guaranteed that for the given test cases there is always possible to find a binary
  * search tree with the given requirements.
  */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);

    }

    private TreeNode buildTree(int[] preorder, int from, int to) {
        if (from > to || to >= preorder.length) {
            return null;
        } else if (from == to) {
            return new TreeNode(preorder[from]);
        }

        TreeNode node = new TreeNode(preorder[from]);

        // find the first element that is larger than the head (from)
        int end = from;
        while (end <= to && preorder[end] <= preorder[from]) end++;
        
        node.left = buildTree(preorder, from+1, end-1);
        node.right = buildTree(preorder, end, to);
        return node;
    }
}
