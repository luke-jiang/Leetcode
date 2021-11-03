class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                    if (node.right == null) res.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    if (node.left == null) res.add(node.right.val);
                }
            }
        }
        return res;
    }
}

class Solution {
    List<Integer> res;
    public List<Integer> getLonelyNodes(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right == null) {
            res.add(root.left.val);
        }
        if (root.left == null && root.right != null) {
            res.add(root.right.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
