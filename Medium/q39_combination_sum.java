// [Backtracking]

/** Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
  * find all unique combinations in candidates where the candidate numbers sums to target.
  * The same repeated number may be chosen from candidates unlimited number of times.\
  * All numbers (including target) will be positive integers.
  * The solution set must not contain duplicate combinations.
  *
  * Example:
  * candicates = [2,3,6,7], target = 7, return [[7], [2,2,3]]
  */

  class Solution {
      // more compact version
      List<List<Integer>> res;

      public List<List<Integer>> combinationSum(int[] candidates, int target) {
          res = new ArrayList<>();
          backtrack(candidates, 0, target, new ArrayList<>());
          return res;
      }

      // curr is the current index of cand to begin searching, curr is used to
      // avoid duplicates.
      private void backtrack(int[] cand, int curr, int target, List<Integer> path) {
          if (target == 0) {
              res.add(new ArrayList(path));
              return;
          } else if (target < 0) {
              return;
          }
          for (int i = curr; i < cand.length; i++) {
              path.add(cand[i]);
              backtrack(cand, i, target-cand[i], path);
              path.remove(path.size()-1);
          }
      }
  }

class Solution {
    // recursive backtracking

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void backtrack(List<Integer> ls, int[] candidates, int index, int target) {
        if (target == 0) { // found a solution
            List<Integer> ls1 = new ArrayList<>();
            ls1.addAll(ls);
            res.add(ls1);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int x = candidates[i];
            ls.add(x);
            target -= x;
            if (target >= 0) {
                backtrack(ls, candidates, i, target);
            }
            ls.remove(ls.size()-1);
            target += x;
        }
    }
}
