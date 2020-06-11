// [TreeTraversal, Recursion]

/** Given preorder and inorder traversal of a tree, construct the binary tree.
  *
  * Note:
  * You may assume that duplicates do not exist in the tree.
  *
  * Example:
  * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
  * return [3,9,null,null,15,7]
  */

class Solution {

    // map keeps track of the inorder index for each node
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, inorder, 0, 0, len-1);
        return root;
    }

    // index is the root of the tree to be built
    // from and to are the inorder range of subtree nodes
    private TreeNode buildTree(int[] preorder, int[] inorder, int index, int from, int to) {
        if (from > to) return null;

        int val = preorder[index];
        TreeNode root = new TreeNode(val);
        int root_inorder = map.get(val);

        // key here: it's possible to know the sizes of subtrees
        int left_size = root_inorder - from;
        int right_size = to - root_inorder;

        root.left  = buildTree(preorder, inorder, index+1, from, root_inorder-1);
        root.right = buildTree(preorder, inorder, index+left_size+1, root_inorder+1, to);
        return root;

    }
}
