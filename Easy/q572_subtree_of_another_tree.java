/** Given two non-empty binary trees s and t, check whether tree t has exactly the
  * same structure and node values with a subtree of s. A subtree of s is a tree
  * consists of a node in s and all of this node's descendants. The tree s could
  * also be considered as a subtree of itself.
  *
  * Example 1:
  * Given tree s:

         3
        / \
       4   5
      / \
     1   2
  *
  * Given tree t:
       4
      / \
     1   2
  *
  * Return true, because t has the same structure and node values with a subtree of s.
  *
  * Example 2:
  * Given tree s:

         3
        / \
       4   5
      / \
     1   2
        /
       0
  * Given tree t:
       4
      / \
     1   2
  * Return false.
  */


class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = s;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val == t.val && same(curr, t)) {
                // System.out.println(curr.val);
                return true;
            }
            curr = curr.right;
        }
        return false;
    }

    private boolean same(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && same(s.left, t.left) && same(s.right, t.right);
        }
    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        } else if (subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val && sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean sameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        else if (r1 == null || r2 == null) return false;
        return r1.val == r2.val && sameTree(r1.left, r2.left) && sameTree(r1.right, r2.right);
    }
}
