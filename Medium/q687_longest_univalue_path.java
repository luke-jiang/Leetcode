class Solution {
    int max = 1;
    
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max - 1;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int lsum = helper(root.left);
        int rsum = helper(root.right);
        
        int through = 1;
        int ends = 0;
        if (root.left != null && root.left.val == root.val) {
            through += lsum;
            ends = Math.max(ends, lsum);
        }
        if (root.right != null && root.right.val == root.val) {
            through += rsum;
            ends = Math.max(ends, rsum);
        }
        
        max = Math.max(max, through);
        return 1 + ends;
    }
}
