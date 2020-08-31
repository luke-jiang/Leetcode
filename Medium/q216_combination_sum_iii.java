// [Backtracking]

/** Find all possible combinations of k numbers that add up to a number n, given that
  * only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
  *
  * Note:
  * All numbers will be positive integers.
  * The solution set must not contain duplicate combinations.
  *
  * Example 1:
  * Input: k = 3, n = 7
  * Output: [[1,2,4]]
  *
  * Example 2:
  * Input: k = 3, n = 9
  * Output: [[1,2,6], [1,3,5], [2,3,4]]
  */

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        boolean[] used = new boolean[10];
        backtrack(k, n, 1, used, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int k, int n, int index, boolean[] used, int sum, List<Integer> path) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList(path));
            }
        } else {
            for (int i = index; i < 10; i++) {
                if (!used[i]) {
                    used[i] = true;
                    sum += i;
                    path.add(i);
                    backtrack(k, n, i, used, sum, path);
                    path.remove(path.size()-1);
                    sum -= i;
                    used[i] = false;
                }
            }
        }
    }
}
