// [Tree Traversal]

/** Given a binary tree, return the inorder traversal of its nodes' values.
  * Example:
  * Input: [1,null,2,3]
       1
        \
         2
        /
       3
  * Output: [1,3,2]
  * Follow up: Recursive solution is trivial, could you do it iteratively?
  */
  
class Solution1 {
    // inorder traversal using stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}


class Solution2 {
    // recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i : inorderTraversal(root.left)) {
            res.add(i);
        }
        res.add(root.val);
        for(int i : inorderTraversal(root.right)) {
            res.add(i);
        }
        return res;
    }
}
