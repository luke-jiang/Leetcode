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


class Solution1 {
    Map<TreeNode, TreeNode> parents;

    // use a ParentMap, then do K-step BFS
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
                TreeNode left = node.left;
                TreeNode right = node.right;
                TreeNode parent = parents.get(node);

                if (left != null && !seen.contains(left)) {
                    q.add(left);
                    seen.add(left);
                }
                if (right != null && !seen.contains(right)) {
                    q.add(right);
                    seen.add(right);
                }
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


class Solution2 {
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
