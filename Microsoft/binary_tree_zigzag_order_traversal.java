class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = q.remove();
                if (next.left != null) q.add(next.left);
                if (next.right != null) q.add(next.right);
                if (depth % 2 == 0) {
                    level.add(next.val);
                } else {
                    level.add(0, next.val);
                }
            }
            depth++;
            res.add(level);
        }
        
        return res;
    }
}
