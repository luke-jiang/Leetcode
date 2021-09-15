class Solution {
    Map<TreeNode, TreeNode> parents;
    
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        parents = new HashMap<>();
        TreeNode from = findNode(root, p);
        buildParent(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(from);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(from);
        
        boolean found = false;
        int res = 0;
        while (!found && !queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.remove();
                TreeNode ln = next.left;
                TreeNode rn = next.right;
                TreeNode pn = parents.get(next);
                
                if (ln != null && !seen.contains(ln)) {
                    found = found || (ln.val == q);
                    queue.add(ln);
                    seen.add(ln);
                }
                if (rn != null && !seen.contains(rn)) {
                    found = found || (rn.val == q);
                    queue.add(rn);
                    seen.add(rn);
                }
                if (pn != null && !seen.contains(pn)) {
                    found = found || (pn.val == q);
                    queue.add(pn);
                    seen.add(pn);
                }
            }
        }
        return res;
    }
    
    private TreeNode findNode(TreeNode n, int i) {
        if (n == null || n.val == i) return n;
        TreeNode tmp = findNode(n.left, i);
        if (tmp != null) return tmp;
        return findNode(n.right, i);
    }
    
    private void buildParent(TreeNode n, TreeNode p) {
        if (n == null) return;
        parents.put(n, p);
        buildParent(n.left, n);
        buildParent(n.right, n);
    }
}
