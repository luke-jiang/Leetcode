// [BST, Inorder-Traversal] ***

/** Given a binary tree, determine if it is a valid binary search tree (BST).
  * Assume a BST is defined as follows:
  * The left subtree of a node contains only nodes with keys less than the node's key.
  * The right subtree of a node contains only nodes with keys greater than the node's key.
  * Both the left and right subtrees must also be binary search trees.
  *
  * Example 1:
  * Input: [2,1,3]
  * Output: true
  *
  * Example 2:
  * Input: [5,1,4,null,null,3,6]
  * Output: false
  * Explanation: The root node's value is 5 but its right child's value is 4.
  */

// key here is to use Integer instead of int to specify initial search range.

class Solution {
  // recursion
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer from, Integer to) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (from != null && val <= from) return false;
        if (to != null && val >= to) return false;

        if (!dfs(root.right, val, to)) return false;
        if (!dfs(root.left, from, val)) return false;

        return true;
    }
}

class Solution {
    // recursion version 2, use Integer type to avoid overflow.
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (root.val < left || root.val > right) return false;
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }
}

class Solution {
    // inorder traversal using stack
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }

        return true;
    }
}
