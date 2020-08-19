// [DP]

/** Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
  * Example 1:
  * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
  * Output: true
  *
  * Example 2:
  * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
  * Output: false
  */

class Solution {
    int[][][] dp;
    String s1;
    String s2;
    String s3;


    // dp(i, j, k) := true if s3[0, k] is an interleave of s1[0, i] and s2[0, j]
    // eventually return dp(s1.len-1, s2.len-1, s3.len-1)
    // dp(i, j, k) =
    //  true if i < 0 && j < 0 && k < 0   // all empty
    //  s1[0, i] == s3[0, k] if j < 0     // the second string is empty, return true iff s1 == s3.
    //  s2[0, j] == s3[0, k] if i < 0     // similar to previous case
    //  k < 0 && (s1 > 0 || s2 > 0)
    //  dp(i-1, j, k) || dp(i, j-1, k)    // if s1[i] == s2[j] == s3[k]
    //  dp(i-1, j, k)                     // if s1[i] == s3[k]
    //  dp(i, j-1, k)                     // if s2[j] == s3[k]
    //  0                                 // if s1[i] != s3[k] && s2[j] != s3[k]
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) {
            return false;
        }

        dp = new int[len1][len2][len3];
        for (int[][] arrs : dp) {
            for (int[] arr : arrs) {
                Arrays.fill(arr, -1);
            }
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return search(len1-1, len2-1, len3-1) == 1;
    }

    private int search(int i, int j, int k) {
        if (i < 0 && j < 0 && k < 0) {
            return 1;
        } else if (i < 0) {
            boolean subequals = this.s2.substring(0, j+1).equals(this.s3.substring(0, k+1));
            return subequals ? 1 : 0;
        } else if (j < 0) {
            boolean subequals = this.s1.substring(0, i+1).equals(this.s3.substring(0, k+1));
            return subequals ? 1 : 0;
        } else if (k < 0) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        char c1 = this.s1.charAt(i);
        char c2 = this.s2.charAt(j);
        char c3 = this.s3.charAt(k);

        if (c1 == c2 && c2 == c3) {
            dp[i][j][k] = search(i-1, j, k-1) == 1 || search(i, j-1, k-1) == 1 ? 1 : 0;
        } else if (c1 == c3) {
            dp[i][j][k] = search(i-1, j, k-1);
        } else if (c2 == c3) {
            dp[i][j][k] = search(i, j-1, k-1);
        } else {
            dp[i][j][k] = 0;
        }

        return dp[i][j][k];
    }
}
