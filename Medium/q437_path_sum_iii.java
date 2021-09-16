// [Tree] ***

/** You are given a binary tree in which each node contains an integer value.
  * Find the number of paths that sum to a given value.
  * The path does not need to start or end at the root or a leaf, but it must go
  * downwards (traveling only from parent nodes to child nodes).
  * The tree has no more than 1,000 nodes and the values are in the range -1,000,000
  * to 1,000,000.
  *
  * Example:
  * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

  * Return 3. The paths that sum to 8 are:

      1.  5 -> 3
      2.  5 -> 2 -> 1
      3. -3 -> 11
  *
  */

class Solution {
    // recursion
    // KEY here is recursion and binary choice
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathInclude(root, sum, 0);
    }

    private int pathInclude(TreeNode root, int sum, int curr) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int res = 0;
        if (sum == curr) res++;
        res += pathInclude(root.left, sum, curr);
        res += pathInclude(root.right, sum, curr);
        return res;
    }
}

class Solution {
    int count = 0;
    int k;
    //      sum  -> frequency
    HashMap<Integer, Integer> h = new HashMap<>();

    // prefix sum
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;

        // path from root to node
        if (sum == k) count++;

        count += h.getOrDefault(sum-k, 0);

        // add current sum to the map for child nodes
        h.put(sum, h.getOrDefault(sum, 0) + 1);

        preorder(node.left, sum);
        preorder(node.right, sum);

        // remove current sum from the map to avoid using it
        // in the parallel subtree processing
        h.put(sum, h.get(sum) - 1);
    }
}
