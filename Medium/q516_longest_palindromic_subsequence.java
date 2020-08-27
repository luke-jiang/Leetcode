// [DP]

/** Given a string s, find the longest palindromic subsequence's length in s.
  * You may assume that the maximum length of s is 1000.
  *
  * Example 1:
  * Input:      "bbbab"
  * Output:     4
  * One possible longest palindromic subsequence is "bbbb".
  *
  * Example 2:
  * Input:      "cbbd"
  * Output:     2
  * One possible longest palindromic subsequence is "bb".
  *
  * Constraints:
  * 1 <= s.length <= 1000
  * s consists only of lowercase English letters.
  */

class Solution {
    int[][] dp;
    int len;

    // dp(i, j) := length of the longest palindromic subsequence in s[i, j]
    // dp(i, j) := {
    //    0,                  if i > j or i/j out of range
    //    1,                  if i == j  i.e. a char is a palindromic subsequence
    //    2 + dp(i+1, j-1)    if s[i] == s[j]
    //    max { dp(i+1, j), dp(i, j-1) }
    // }

    public int longestPalindromeSubseq(String s) {
        len = s.length();
        dp = new int[len][len];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return search(s, 0, len-1);
    }

    private int search(String s, int i, int j) {
        if (i < 0 || i >= len || j < 0 || j >= len || i > j) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + search(s, i+1, j-1);
        } else {
            dp[i][j] = Math.max(search(s, i+1, j), search(s, i, j-1));
        }

        return dp[i][j];
    }
}
