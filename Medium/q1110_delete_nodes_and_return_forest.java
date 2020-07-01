// [BST]

/** Given the root of a binary tree, each node in the tree has a distinct value.
  * After deleting all nodes with a value in to_delete, we are left with a forest
  * (a disjoint union of trees).
  * Return the roots of the trees in the remaining forest.  You may return the result
  * in any order.
  *
  * Example 1:
  * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
  * Output: [[1,2,null,4],[6],[7]]
  *
  * Constraints:
  * The number of nodes in the given tree is at most 1000.
  * Each node has a distinct value between 1 and 1000.
  * to_delete.length <= 1000
  * to_delete contains distinct values between 1 and 1000.
  */

class Solution {
    TreeNode[] int2node = new TreeNode[1001];
    int[] parent = new int[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();

        dfs(root, 0);

        for (int i : to_delete) {
            TreeNode node = int2node[i];
            if (node == null) continue;

            // remove node from parent
            int p = parent[i];
            TreeNode pnode = int2node[p];
            if (pnode != null && pnode.left == node) {
                pnode.left = null;
            } else if (pnode != null) {
                pnode.right = null;
            }

            // remove node from children
            if (node.left != null) {
                parent[node.left.val] = 0;
                node.left = null;
            }
            if (node.right != null) {
                parent[node.right.val] = 0;
                node.right = null;
            }

            // remove node i from int2node
            int2node[i] = null;
        }

        for (int i = 0; i < int2node.length; i++) {
            if (int2node[i] != null && parent[i] == 0) {
                res.add(int2node[i]);
            }
        }

        return res;
    }

    // populate the two arrays
    private void dfs(TreeNode root, int p) {
        int2node[root.val] = root;
        parent[root.val] = p;
        if (root.left != null) {
            dfs(root.left, root.val);
        }
        if (root.right != null) {
            dfs(root.right, root.val);
        }
    }
}