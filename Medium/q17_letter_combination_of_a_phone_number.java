// [Backtracking, DFS]

/** Given a string containing digits from 2-9 inclusive, return all possible letter
  * combinations that the number could represent
  * A mapping of digit to letters (just like on the telephone buttons) is given below.
  * Note that 1 does not map to any letters.
  *   2 -> a, b, c
  *   3 -> d, e, f
  *   4 -> g, h, i
  *   5 -> j, k, l
  *   6 -> m, n, o
  *   7 -> p, q, r, s
  *   8 -> t, u, v
  *   9 -> w, x, y, z
  *
  * Example:
  * "23" -> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
  */

class Solution {
    String[] map = new String[] {
        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() > 0)
            dfs("", 0, digits);
        return res;
    }

    public void dfs(String curr, int index, String digits) {
        if (index >= digits.length()) {
            res.add(curr);
        } else {
            String chars = map[digits.charAt(index) - '0' - 2];
            for (int i = 0; i < chars.length(); i++) {
                dfs(curr + chars.charAt(i), index+1, digits);
            }
        }
    }
}
