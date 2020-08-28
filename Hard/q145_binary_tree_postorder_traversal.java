// [Tree Traversal]

/** Given a binary tree, return the postorder traversal of its nodes' values.
  * Example:
  * Input: [1,null,2,3]
       1
        \
         2
        /
       3
  * Output: [3,2,1]
  * Follow up: Recursive solution is trivial, could you do it iteratively?
  */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return res;
        }
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);
            if (curr.left != null) st.push(curr.left);
            if (curr.right != null) st.push(curr.right);
        }

        Collections.reverse(res);

        return res;
    }
}
