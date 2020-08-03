// [DP]

/** Given two strings text1 and text2, return the length of their longest common subsequence.
  * A subsequence of a string is a new string generated from the original string with some
  * characters(can be none) deleted without changing the relative order of the remaining characters.
  * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
  * is a subsequence that is common to both strings.
  * If there is no common subsequence, return 0.
  *
  * Example 1:
  * Input: text1 = "abcde", text2 = "ace"
  * Output: 3
  * Explanation: The longest common subsequence is "ace" and its length is 3.
  *
  * Example 2:
  * Input: text1 = "abc", text2 = "abc"
  * Output: 3
  * Explanation: The longest common subsequence is "abc" and its length is 3.
  *
  * Example 3:
  * Input: text1 = "abc", text2 = "def"
  * Output: 0
  * Explanation: There is no such common subsequence, so the result is 0.
  */

class Solution {
    int len1;
    int len2;
    int[][] dp;
    String s1;
    String s2;

    public int longestCommonSubsequence(String text1, String text2) {
        len1 = text1.length();
        len2 = text2.length();
        s1 = text1;
        s2 = text2;
        if (len1 == 0 || len2 == 0) return 0;

        dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = -1;
            }
        }

        return recurse(len1-1, len2-1);
    }

    private int recurse(int i, int j) {
        if (i < 0 || j < 0) return 0;
        // if (i >= len1) return recurse(i-1, j);
        // if (j >= len2) return recurse(i, j-1);
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + recurse(i-1, j-1);
        } else {
            dp[i][j] = Math.max(recurse(i, j-1), recurse(i-1, j));
        }
        return dp[i][j];
    }
}
