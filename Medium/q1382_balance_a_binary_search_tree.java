class Solution {
    List<TreeNode> flatten;
    public TreeNode balanceBST(TreeNode root) {
        flatten = new ArrayList<>();
        inorder(root);
        return reconstruct(flatten, 0, flatten.size() - 1);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        flatten.add(root);
        inorder(root.right);
    }
    
    private TreeNode reconstruct(List<TreeNode> flatten, int from, int to) {
        if (from > to) return null;
        int mid = from + (to - from) / 2;
        TreeNode root = flatten.get(mid);
        root.left = reconstruct(flatten, from, mid - 1);
        root.right = reconstruct(flatten, mid + 1, to);
        return root;
    }
}
