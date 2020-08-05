// [BST]

/** Given an integer n, generate all structurally unique BST's (binary search trees)
  * that store values 1 ... n.
  *
  * Example:
  *
  * Input: 3
  * Output:
    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]
  */

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> res = new ArrayList<>();
        if (from > to) {
            res.add(null);
            return res;
        }

        for (int i = from; i <= to; i++) {
            List<TreeNode> leftTrees = generateTrees(from, i-1);
            List<TreeNode> rightTrees = generateTrees(i+1, to);

            for (TreeNode lnode : leftTrees) {
                for (TreeNode rnode : rightTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = lnode;
                    curr.right = rnode;
                    res.add(curr);
                }
            }
        }

        return res;
    }
}
