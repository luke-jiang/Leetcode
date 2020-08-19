// [DP, two pointers]

/** Given strings S and T, find the minimum (contiguous) substring W of S, so that
  * T is a subsequence of W.
  * If there is no such window in S that covers all characters in T, return the
  * empty string "". If there are multiple such minimum-length windows, return the
  * one with the left-most starting index.
  *
  * Example 1:
  * Input:
  * S = "abcdebdde", T = "bde"
  * Output: "bcde"
  * Explanation:
  * "bcde" is the answer because it occurs before "bdde" which has the same length.
  * "deb" is not a smaller window because the elements of T in the window must occur
  * in order.
  *
  * Note:
  * All the strings in the input will only contain lowercase letters.
  * The length of S will be in the range [1, 20000].
  * The length of T will be in the range [1, 100].
  */

class Solution1 {

    // DP solution
    // dp[i][j] := starting index of pattern T[0, i] in S[0, j]
    // dp[i][j] := if S[j] == T[i] then dp[i-1][j-1] else dp[i][j-1]
    // eventually find the minimum window in the last array.
    public String minWindow(String S, String T) {
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m+1][n+1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        int start = 0;
        int len = n+1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] -1;
                    len = j - dp[m][j] + 1;
                }
            }
        }

        return len == n + 1 ? "" : S.substring(start, start + len);
    }
}


class Solution2 {
    // two pointers
    // try to find a substring in S that contains T, then go back to find the
    // starting position of S.
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int minlen = Integer.MAX_VALUE;
        int slen = S.length(), tlen = T.length();
        int si = 0, ti = 0;
        int min_s = -1;

        while (si < slen) {
            if (s[si] == t[ti]) {
                ti++;
                if (ti == tlen) {
                    // found a candidate substring
                    int curr_end = si+1;
                    ti--;
                    // trace back to the starting position
                    while (ti >= 0) {
                        while (s[si] != t[ti]) {
                            si--;
                        }
                        si--;
                        ti--;
                    }
                    si++;
                    ti++;
                    int curr_len = curr_end - si;
                    if (curr_len < minlen) {
                        minlen = curr_len;
                        min_s = si;
                    }
                }
            }
            si++;
        }
    }
}
