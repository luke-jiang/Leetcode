// [SlidingWindow, DP]

/** Given a string s, find the longest palindromic substring in s.
  * You may assume that the maximum length of s is 1000.
  *
  * Examples:
  * "babad" -> "bab" || "aba"
  * "cbbd" -> "bb"
  * "abcda" -> "a"
  */

class Solution {
    // DP
    // dp[i][j] is true iff s[i, j] is palindromic
    // dp[i][j] =
    // | true                    if i == j
    // | s[i] == s[j]            if i == j + 1
    // | i == j /\ dp[i+1][j-1]  else
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return "";

        boolean[][] dp = new boolean[len][len];

        // indices of the desired substring
        int start = 0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                boolean endEq = (s.charAt(i) == s.charAt(j));
                if (i == j) {
                    // a char by itself is palindromic
                    dp[i][j] = true;
                } else if (i - j == 1) {
                    // a string of form "ab" is palindromic iff 'a' == 'b'
                    dp[i][j] = endEq;
                } else if (endEq && dp[i-1][j+1]) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && i - j > end - start) {
                    end = i;
                    start = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}

class Solution {
    int max;
    String substring;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;

        max = 1;
        substring = s.substring(0, 1);

        for (int i = 0; i < len; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }

        return substring;
    }

    private void expand(String s, int from, int to) {
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
                from--; to++;
        }
        int len = Math.max(max, to-from-1);
        if (len > max) {
            max = len;
            substring = s.substring(from+1, to);
        }
    }
}



class Solution {
    int maxlen;
    int start;
    int end;
    int[][] dp;

    // dp memoization
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        maxlen = 1;
        // res = "" + s.charAt(0);
        start = 0;
        end = 0;
        dp = new int[n][n];
        search(s, 0, n-1);

        return s.substring(start, end+1);
    }

    private int search(String s, int i, int j) {
        if (i > j) {
            return 0;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j) && search(s, i+1, j-1) == j-i-1) {
            dp[i][j] = j-i+1;
        } else {
            dp[i][j] = Math.max(search(s, i+1, j), search(s, i, j-1));
        }

        if (dp[i][j] > maxlen) {
            maxlen = dp[i][j];
            start = i;
            end = j;
        }

        return dp[i][j];
    }
}
