class Solution {
    Map<TreeNode, Integer> depths;
    int maxdepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depths = new HashMap<>();
        dfs(root, 0);
        /*
        for (TreeNode n : depths.keySet()) {
            System.out.println(n.val + ":" + depths.get(n));
        }*/
        TreeNode curr = root;
        while (curr != null && depths.get(curr) == maxdepth) {
            if (curr.left == null && curr.right == null) {
                break;
            } else if (curr.left == null) {
                curr = curr.right;
            } else if (curr.right == null) {
                curr = curr.left;
            } else if (depths.get(curr.left) < maxdepth) {
                curr = curr.right;
            } else if (depths.get(curr.right) < maxdepth) {
                curr = curr.left;
            } else {
                break;
            }
        }
        return curr;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return -1;
        } else {
            int left_depth = dfs(node.left, depth+1);
            int right_depth = dfs(node.right, depth+1);
            int max = Math.max(depth, Math.max(left_depth, right_depth));
            depths.put(node, max);
            maxdepth = Math.max(maxdepth, max);
            return max;
        }
    }
}
