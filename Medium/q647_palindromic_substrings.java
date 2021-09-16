// [DP]

/** Given a string, your task is to count how many palindromic substrings in this string.
  * The substrings with different start indexes or end indexes are counted as different
  * substrings even they consist of same characters.
  *
  * Example 1:
  * Input: "abc"
  * Output: 3
  * Explanation: Three palindromic strings: "a", "b", "c".
  *
  * Example 2:
  * Input: "aaa"
  * Output: 6
  * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
  *
  * Note:
  * The input string length won't exceed 1000.
  */

class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        search(s, 0, n-1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1) res++;
            }
        }
        return res;
    }

    private int search(String s, int i, int j) {
        if (i > j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == j) {
            dp[i][j] = 1;
            return dp[i][j];
        }

        search(s, i+1, j);
        search(s, i, j-1);
        if (search(s, i+1, j-1) == 1 && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += expand(s, i, i) + expand(s, i, i+1);
        }
        return res;
    }

    private int expand(String s, int i, int j) {
        int res = 0;
        int from = i;
        int to = j;
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
            res++;
            from--;
            to++;
        }
        return res;
    }
}
