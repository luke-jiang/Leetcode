// [HashMap, DFS]

/** Given the root of a tree, you are asked to find the most frequent subtree sum.
  * The subtree sum of a node is defined as the sum of all the node values formed
  * by the subtree rooted at that node (including the node itself). So what is the
  * most frequent subtree sum value? If there is a tie, return all the values with
  * the highest frequency in any order.
  *
  * Examples 1
  * Input: [5,1,3]
` * return [2, -3, 4], since all the values happen only once, return all of them in any order.
  *
  * Examples 2
  * Input: [5,2,-5]
  * return [2], since 2 happens twice, however -5 only occur once.
  *
  * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
  */
  
class Solution {
    Map<Integer, Integer> map;
    int max;


    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        max = 0;
        dfs(root);
        List<Integer> ls = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == max) {
                ls.add(sum);
            }
        }

        int[] res = new int[ls.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ls.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int val = root.val + dfs(root.left) + dfs(root.right);
            int freq = map.getOrDefault(val, 0) + 1;
            map.put(val, freq);
            max = Math.max(max, freq);
            return val;
        }
    }
}
