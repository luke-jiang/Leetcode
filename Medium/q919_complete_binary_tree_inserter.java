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
class CBTInserter {
    TreeNode[] tree;
    int next;

    public CBTInserter(TreeNode root) {
        tree = new TreeNode[2002];
        initialize(root, 1);
        next = 1;
        while (tree[next] != null) next++;
    }
    
    private void initialize(TreeNode root, int index) {
        if (root == null) return;
        tree[index] = root;
        initialize(root.left, index * 2);
        initialize(root.right, index * 2 + 1);
    }
    
    public int insert(int val) {
        tree[next] = new TreeNode(val);
        TreeNode parent = tree[next / 2];
        if (next % 2 == 0) {
            parent.left = tree[next];
        } else {
            parent.right = tree[next];
        }
        next++;
        return parent.val;
    }
    
    public TreeNode get_root() {
        return tree[1];
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */