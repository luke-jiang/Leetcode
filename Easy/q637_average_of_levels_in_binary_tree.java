class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Integer sz = q.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(sum * 1.0 / sz);
        }
        return res;
    }
}
