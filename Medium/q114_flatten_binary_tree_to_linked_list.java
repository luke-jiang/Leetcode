// [Tree]

/** Given a binary tree, flatten it to a linked list in-place.
  * For example, given the following tree:

        1
       / \
      2   5
     / \   \
    3   4   6

  * The flattened tree should look like:

        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6
  */

class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            helper(root);
        }
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftend = helper(root.left);
        TreeNode rightend = helper(root.right);

        if (leftend != null) {
            leftend.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightend == null ? leftend : rightend;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode node) {
        if (node == null) return node;
        if (node.left == null && node.right == null) return node;

        TreeNode left = node.left;
        TreeNode right = node.right;

        TreeNode nleft = helper(node.left);
        TreeNode nright = helper(node.right);

        node.left = null;
        if (left == null && right != null) {
            node.right = right;
            return nright;
        } else if (left != null && right == null) {
            node.right = left;
            return nleft;
        } else {
            node.right = left;
            nleft.right = right;
            return nright;
        }
    }
}

class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode beginl = root.left;
        TreeNode beginr = root.right;
        TreeNode endl = helper(beginl);
        TreeNode endr = helper(beginr);
        TreeNode end = root;
        if (endl != null) {
            end.right = beginl;
            end = endl;
        }
        if (endr != null) {
            end.right = beginr;
            end = endr;
        }
        root.left = null;
        return end;
    }
}
