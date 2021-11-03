class Solution {
    double max;
    public double maximumAverageSubtree(TreeNode root) {
        max = 0.0;
        dfs(root);
        return max;
    }
    
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int totalSum = left[0] + right[0] + root.val;
        int totalCount = left[1] + right[1] + 1;
        
        double avg = totalSum * 1.0 / totalCount;
        max = Math.max(max, avg);
        
        return new int[] {totalSum, totalCount};
    }
}
