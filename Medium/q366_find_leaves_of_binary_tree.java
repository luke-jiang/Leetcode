// [Tree]

/** Given a binary tree, collect a tree's nodes as if you were doing this: Collect
  * and remove all leaves, repeat until the tree is empty.
  *
  * Example:
  * Input: [1,2,3,4,5]

          1
         / \
        2   3
       / \
      4   5

  * Output: [[4,5,3],[2],[1]]
  */

class Solution {
    // map stores the depth of all nodes in the tree.
    // starting with leaf nodes of depth 1.
    Map<TreeNode, Integer> map;
    int max;        // maximum depth

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<>();
        map = new HashMap<>();
        max = 1;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            map.put(node, -1);
            if (node.left != null) s.push(node.left);
            if (node.right != null) s.push(node.right);
        }

        depth(root);

        List<List<Integer>> res = new ArrayList<>(max);

        for (int i = 0; i < max; i++) {
            res.add(new ArrayList<>());
        }

        for (TreeNode key : map.keySet()) {
            int val = map.get(key);
            res.get(val-1).add(key.val);
        }
        return res;
    }

    // finds the (maximum) depth of each node
    private void depth(TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            map.put(root, 1);
        } else {
            depth(root.left);
            depth(root.right);
            int d = 0;
            if (root.left != null) {
                d = Math.max(d, map.get(root.left));
            }
            if (root.right != null) {
                d = Math.max(d, map.get(root.right));
            }
            d += 1;

            map.put(root, d);
            max = Math.max(max, d);
        }
    }
}
