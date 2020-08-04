// [backtracking]

/** Given a string s, partition s such that every substring of the partition is a palindrome.
  * Return all possible palindrome partitioning of s.
  * Example:
  * Input: "aab"
  * Output:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
  */
  
class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int from, List<String> curr) {
        if (from >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = from; i < s.length(); i++) {
            if (palindromic(s, from, i)) {
                curr.add(s.substring(from, i+1));
                backtrack(s, i+1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean palindromic(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
}
