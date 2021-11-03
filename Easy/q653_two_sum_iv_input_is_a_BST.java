class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> complement = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            complement.add(k - root.val);
            root = root.left;
        }
        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            if (complement.contains(n.val) && n.val + n.val != k) return true;
            complement.add(k - n.val);
            TreeNode tmp = n.right;
            while (tmp != null) {
                st.add(tmp);
                tmp = tmp.left;
            }
        }
        return false;
    }
}
