class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return helper(root, new ArrayList<>());
    }
    
    private List<Integer> helper(TreeNode root, List<Integer> ls) {
        if (root == null) return ls;
        List<Integer> t = helper(root.left, ls);
        t.add(root.val);
        return helper(root.right, t);
    }
}
