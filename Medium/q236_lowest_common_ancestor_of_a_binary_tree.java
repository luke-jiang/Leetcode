// [Parent-Map]

/** Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
  * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
  * between two nodes p and q as the lowest node in T that has both p and q as descendants
  * (where we allow a node to be a descendant of itself).”
  *
  * Example 1:
  * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
  * Output: 3
  * Explanation: The LCA of nodes 5 and 1 is 3.
  *
  * Example 2:
  * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
  * Output: 5
  * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
  * according to the LCA definition.
  *
  * Note:
  * All of the nodes' values will be unique.
  * p and q are different and both values will exist in the binary tree.
  */

class Solution {
    Map<TreeNode, TreeNode> parent;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();
        findParents(root);

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    private void findParents(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
            findParents(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            findParents(root.right);
        }
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> st = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        st.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode n = st.pop();
            if (n.left != null) {
                parent.put(n.left, n);
                st.push(n.left);
            }
            if (n.right != null) {
                parent.put(n.right, n);
                st.push(n.right);
            }
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
        
    }
}


class Solution {
    // recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }
}
