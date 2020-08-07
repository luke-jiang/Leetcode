// [Tree]

/** Given a binary tree, return all root-to-leaf paths.
  * Note: A leaf is a node with no children.
  *
  * Example:
  * Input:

       1
     /   \
    2     3
     \
      5

  * Output: ["1->2->5", "1->3"]
  * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
  */

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(res, sb, root);
        return res;
    }

    public void helper(List<String> res, StringBuilder sb, TreeNode root){
        if (root == null) return;
        int tmp = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(tmp, sb.length());
            return;
        }
        sb.append(root.val + "->");
        helper(res, sb, root.left);
        helper(res, sb, root.right);
        sb.delete(tmp , sb.length());
        return;

    }
}
