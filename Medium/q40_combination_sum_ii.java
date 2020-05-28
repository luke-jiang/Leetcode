// [Backtracking]

/** Given a collection of candidate numbers (candidates) and a target number (target),
  * find all unique combinations in candidates where the candidate numbers sums to target.
  * Each number in candidates may only be used once in the combination.
  * All numbers (including target) will be positive integers.
  * The solution set must not contain duplicate combinations.
  */


class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        // easier if sorted
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);

        return res;
    }

    public void backtrack(List<Integer> ls, int[] candidates, int target, int index) {
        if (target == 0) { // found a solution
            List<Integer> ls1 = new ArrayList<>();
            ls1.addAll(ls);
            res.add(ls1);
            return;
        }
        // prev is the previous explored number in ls. This makes
        // sure the arrays in outputs do not decrease (to remove equivalent arrays)
        int prev = -1;
        if (ls.size() > 0) prev = ls.get(ls.size()-1);

        // the previously explored number in the for loop.
        int prev1 = -1;

        for (int i = index; i < candidates.length; i++) {
            int x = candidates[i];
            if (x < prev || x == prev1) {
                continue;
            }
            prev1 = x;

            ls.add(x);
            target -= x;
            if (target >= 0) {
                backtrack(ls, candidates, target, i+1);
            }
            ls.remove(ls.size()-1);
            target += x;

        }
    }
}
