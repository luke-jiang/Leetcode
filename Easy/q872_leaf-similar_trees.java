class Solution {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, true);
        dfs(root2, false);
        return l1.equals(l2);
    }
    
    private void dfs(TreeNode root, boolean one) {
        if (root == null) return;
        else if (root.left == null && root.right == null) {
            List<Integer> ls = one ? l1 : l2;
            ls.add(root.val);
        } else {
            dfs(root.left, one);
            dfs(root.right, one);
        }
    }
}
