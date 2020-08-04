// [Backtracking]

/** Given a collection of integers that might contain duplicates, nums, return all
  * possible subsets (the power set).
  * Note: The solution set must not contain duplicate subsets.
  *
  * Example:
  * Input: [1,2,2]
  * Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
  */
  
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int curr, List<Integer> path) {
        res.add(new ArrayList(path));
        for (int i = curr; i < nums.length; i++) {
            if (i > curr && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
