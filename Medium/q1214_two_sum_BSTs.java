class Solution {
    Set<Integer> complement;
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        complement = new HashSet<>();
        search(root1, target);
        return search(root2);
    }
    
    private void search(TreeNode r, int target) {
        if (r != null) {
            complement.add(target - r.val);
            search(r.left, target);
            search(r.right, target);
        }
    }
    
    private boolean search(TreeNode r) {
        if (r == null) return false;
        if (complement.contains(r.val)) return true;
        return search(r.left) || search(r.right);
    }
}
