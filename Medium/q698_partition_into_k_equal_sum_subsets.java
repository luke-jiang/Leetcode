// [Backtracking]

/** Given an array of integers nums and a positive integer k, find whether it's possible to
  * divide this array into k non-empty subsets whose sums are all equal.
  *
  * Example:
  * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
  * Output: True
  * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
  */

class Solution {
    // if nums can be divided into k subsets, then each subset must
    // have a sum of sum(nums) / k.
    // hard part is how to handle k subsets simultaneously.

    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;

        // visited keeps track of all currently considered numbers.
        boolean[] visited = new boolean[nums.length];
        target = sum/k;
        return dfs(nums, visited, k, 0, 0, 0);
    }

    // start: index to start searching
    // sum: sum of current subset
    // size: number of numbers in the current subset
    public boolean dfs(int[] nums, boolean[] visited, int k, int start, int sum, int size) {
        if (k == 1) {
            // only one set remains to be found.
            // the numbers left are garanteed to have a sum == target, since sum % k must
            // equal to 0.
            return true;
        }
        if (sum == target && size > 0) {
            // found one set, start to try to find another set.
            return dfs(nums, visited, k-1, 0, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            // try all visitable values
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, visited, k, i+1, sum + nums[i], size + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
