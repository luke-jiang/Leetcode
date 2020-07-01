// [Backtracking]

/** Given a collection of numbers that might contain duplicates, return all possible unique permutations.
  * Example:
  * Input: [1,1,2]
  * Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
  */

class Solution {
    List<List<Integer>> res;

    // similar to q46 but without duplicate results.
    // use techniques in q40 to avoid searching duplicates
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i > 0 && !used[i-1] && nums[i] == nums[i-1]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
