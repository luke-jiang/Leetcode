// [Backtracking]

/** Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
  * Example:
  * Input: n = 4, k = 2
  * Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
  */

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        res = new LinkedList<>();
        backtrack(nums, 0, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int curr, int k, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1, k, path);
            path.remove(path.size()-1);
        }
    }
}
