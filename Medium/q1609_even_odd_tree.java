// [Tree BFS]

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEven = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.remove();
                if (isEven && (node.val % 2 == 0 || node.val <= prev)) return false;
                if (!isEven && (node.val % 2 != 0 || node.val >= prev)) return false;
                prev = node.val;
                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            isEven = !isEven;
        }
        return true;
    }
}
