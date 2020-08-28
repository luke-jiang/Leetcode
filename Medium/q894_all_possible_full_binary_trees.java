// [Tree, Caching/DP]

/** A full binary tree is a binary tree where each node has exactly 0 or 2 children.
  * Return a list of all possible full binary trees with N nodes.  Each element of the
  * answer is the root node of one possible tree.
  * Each node of each tree in the answer must have node.val = 0.
  * You may return the final list of trees in any order.
  *
  * Example:
  * Input: 7
  * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
  * [0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
  */

// KEY OBSERVATIONS:
// 1. if N is even, then it's not possible to have FBT.
// 2. N-FBT cosists of (i)-left subtrees and (N-i-1)-right subtrees forall i in [1, N].


class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }

        List<TreeNode> res = new LinkedList<>();

        if (N == 1) {
            // leaf node case, just add a new node to the res list.
            res.add(new TreeNode(0));
            map.put(N, res);
            return res;
        } else if (N % 2 == 0) {
            // a full binary tree cannot have even number of children.
            map.put(N, res);
            return res;
        }

        for (int i = 1; i < N; i+=2) {
            int j = N - i - 1;
            for (TreeNode left : allPossibleFBT(i)) {
                for (TreeNode right : allPossibleFBT(j)) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        map.put(N, res);
        return res;
    }
}

class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
        } else if (N % 2 == 1) {
            for (int i = 0; i < N; i++) {
                int j = N - i - 1;
                if (j % 2 == 0) continue;
                for (TreeNode left : allPossibleFBT(i)) {
                    for(TreeNode right : allPossibleFBT(j)) {
                        TreeNode curr = new TreeNode(0);
                        curr.left = left;
                        curr.right = right;
                        res.add(curr);
                    }
                }
            }
        }
        memo.put(N, res);
        return res;
    }
}
