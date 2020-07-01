// [Backtracking]

/** Given a collection of distinct integers, return all possible permutations.
  * Example:
  * Input: [1,2,3]
  * Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
  */

class Solution {
    List<List<Integer>> res;

    // backtracking with additioanl state variable "used", which stores
    // which numbers have already been used
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
