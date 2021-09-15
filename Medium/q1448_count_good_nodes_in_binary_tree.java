class Solution {
    int res;
    
    public int goodNodes(TreeNode root) {
        res = 0;
        traverse(root, root.val);
        return res;
    }
    
    private void traverse(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) res++;
        traverse(root.left, Math.max(max, root.val));
        traverse(root.right, Math.max(max, root.val));
    }
}
