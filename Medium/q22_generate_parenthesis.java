// [Backtracking]

/** Given n pairs of parentheses, write a function to generate all combinations of
  * well-formed parentheses.
  * For example, given n = 3, a solution set is:
  * [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
  */

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "(", 1, 0, n);
        return res;
    }

    // curr: curr string being built
    // lefts: number of left parentheses in curr
    // rights: number of right parentheses in curr
    public void helper(List<String> res, String curr, int lefts, int rights, int n) {
        if (rights > n || lefts > n || rights > lefts || curr.length() > 2 * n) return;
        if (curr.length() == 2 * n) {
            res.add(curr);
        } else {
            helper(res, curr + '(', lefts + 1, rights, n);
            helper(res, curr + ')', lefts, rights + 1, n);
        }
    }
}
