class Solution {
    // First, try to find if key exists in tree. If node n.val == key,
    // delete n from the tree.
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // found the node whose value is key
            // try to find the rightmost node in the left branch.
            // If found the node != null, make this node the new root.
            TreeNode rightmost = Right(root.left, root);
            if (rightmost != null) {
                rightmost.left = root.left;
                rightmost.right = root.right;
                return rightmost;
            }
            // Similarly, try to find the leftmost node in the right branch.
            TreeNode leftmost = Left(root.right, root);
            if (leftmost != null) {
                leftmost.left = root.left;
                leftmost.right = root.right;
                return leftmost;
            }
            // node is a leaf node, just return null to delete it.
            return null;
        }
    }

    public TreeNode Left(TreeNode root, TreeNode prev) {
        // try to find the leftmost node starting from root.
        // if found, remove the node from the subtree at root
        // and return it. Otherwise, return null.
        // prev is the parent of the current considered node.
        if (root == null) return root;
        while (root.left != null) {
            prev = root;
            root = root.left;
        }
        // remove root from prev.
        if (prev.left == root) {
            prev.left = root.right;
        } else {
            prev.right = root.right;
        }
        root.left = null;
        root.right = null;
        return root;
    }

    public TreeNode Right(TreeNode root, TreeNode prev) {
        // similar to Left().
        if (root == null) return root;
        while (root.right != null) {
            prev = root;
            root = root.right;
        }
        if (prev.left == root) {
            prev.left = root.left;
        } else {
            prev.right = root.left;
        }
        root.left = null;
        root.right = null;
        return root;
    }
}
