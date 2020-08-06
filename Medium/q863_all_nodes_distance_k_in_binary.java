// [BFS, Parent Map] ***

/** We are given a binary tree (with root node root), a target node, and an integer value K.
  * Return a list of the values of all nodes that have a distance K from the target node.
  * The answer can be returned in any order.
  *
  * Example:
  * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
  * Output: [7,4,1]
  * Explanation:
  * The nodes that are a distance 2 from the target node (with value 5)
  * have values 7, 4, and 1.
  */


class Solution {
    Map<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parents = new HashMap<>();
        setParents(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        // use "seen" to avoid root->parent->root paths.
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        for (int i = 0; i < K; i++) { // only do K-step BFS
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.remove();
                if (node.left != null && !seen.contains(node.left)) {
                    q.add(node.left);
                    seen.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    q.add(node.right);
                    seen.add(node.right);
                }
                TreeNode parent = parents.get(node);
                if (parent != null && !seen.contains(parent)) {
                    q.add(parent);
                    seen.add(parent);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (TreeNode n : q) {
            res.add(n.val);
        }
        return res;
    }

    private void setParents(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        setParents(root.left, root);
        setParents(root.right, root);
    }
}
