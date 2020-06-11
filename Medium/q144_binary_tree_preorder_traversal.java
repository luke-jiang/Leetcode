
class Solution1 {
    List<Integer> res;
    // recursive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<Integer>();
        if (root != null) {
            preorder(root);
        }
        return res;
    }

    private void preorder(TreeNode root) {
        res.add(root.val);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }
}

class Solution2 {
    // iterative solution, using stack

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);

            // note the order of adding child nodes
            if (node.right != null) {
                s.push(node.right);
            }

            if (node.left != null) {
                s.push(node.left);
            }
        }

        return res;
    }
}
