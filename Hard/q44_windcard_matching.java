// [DP]

/** Given an input string (s) and a pattern (p), implement wildcard pattern matching
  * with support for '?' and '*'.
  *     '?' Matches any single character.
  *     '*' Matches any sequence of characters (including the empty sequence).
  * The matching should cover the entire input string (not partial).
  *
  * Note:
  * s could be empty and contains only lowercase letters a-z.
  * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
  *
  * Example 1:
  * Input:
  * s = "aa"
  * p = "a"
  * Output: false
  * Explanation: "a" does not match the entire string "aa".
  *
  * Example 2:
  * Input:
  * s = "aa"
  * p = "*"
  * Output: true
  * Explanation: '*' matches any sequence.
  *
  * Example 3:
  * Input:
  * s = "cb"
  * p = "?a"
  * Output: false
  * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
  *
  * Example 4:
  * Input:
  * s = "adceb"
  * p = "*a*b"
  * Output: true
  * Explanation: The first '*' matches the empty sequence, while the second '*'
  * matches the substring "dce".
  *
  * Example 5:
  * Input:
  * s = "acdcb"
  * p = "a*c?b"
  * Output: false
  */

class Solution {
    int[][] dp;

    private String preprocess(String p) {
        if (p.length() == 0) {
            return p;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && sb.charAt(sb.length()-1) == '*') {
                continue;
            }
            sb.append(p.charAt(i));
        }
        return sb.toString();
    }

    public boolean isMatch(String s, String p) {
        p = preprocess(p);

        int n = s.length();
        int m = p.length();

        dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return search(s, p, n-1, m-1) == 1;

    }

    private int search(String s, String p, int i, int j) {
        if (i < 0) {
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') return 0;
            }
            return 1;
        } else if (j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        if (c2 != '?' && c2 != '*') {
            dp[i][j] = (c1 == c2 && search(s, p, i-1, j-1) == 1) ? 1 : 0;
        } else if (c2 == '?') {
            dp[i][j] = search(s, p, i-1, j-1);
        } else {
            dp[i][j] = 0;
            for (int x = -1; x <= i; x++) {
                if (search(s, p, x, j-1) == 1) {
                    System.out.println(x);
                    dp[i][j] = 1;
                    break;
                }
            }
        }
        return dp[i][j];
    }
}


class Solution {
    int[][] dp; // 1 => true, -1 => false, 0 => unsearched
    
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        dp = new int[slen][plen];
        return search(s, p, slen-1, plen-1) == 1;
    }
    
    private int search(String s, String p, int i, int j) {
        // System.out.println("i, j:" + i + "," + j);
        if (i < 0 && j < 0) {
            return 1;
        } else if (i < 0) { // i < 0 /\ j >= 0, can match iff the remaining pattern is *+
            if (p.charAt(j) == '*') return search(s, p, i, j-1);
            else return -1;
        } else if (j < 0) { // i >= 0 /\ j < 0, no pattern to match
            return -1;
        }
        if (dp[i][j] == 0) { // i >= 0 /\ j >= 0
            dp[i][j] = -1;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                // if two chars are the same, consume them
                // if the pattern char is '?', also consume
                dp[i][j] = search(s, p, i-1, j-1);
            } else if (p.charAt(j) == '*') {
                // if the pattern char is '*', it can match substring of any length
                for (int k = i; k >= -1; k--) {
                    if (search(s, p, k, j-1) == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[i][j];
    }
}
