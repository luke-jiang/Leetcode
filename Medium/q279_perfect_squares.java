// [DP]

/** Given a positive integer n, find the least number of perfect square numbers
  * (for example, 1, 4, 9, 16, ...) which sum to n.
  *
  * Example 1:
  * Input: n = 12
  * Output: 3
  * Explanation: 12 = 4 + 4 + 4.
  *
  * Example 2:
  * Input: n = 13
  * Output: 2
  * Explanation: 13 = 4 + 9.
  */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            if ((i * i) >= n+1) break;
            dp[i * i] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            if (dp[i] == 1) continue;
            dp[i] = Integer.MAX_VALUE;
            int j = 1;
            int k = i-1;
            while (j <= k) {
                // traverse all possible (j, k) where j + k = i
                dp[i] = Math.min(dp[i], dp[j] + dp[k]);
                j++;
                k--;
            }
        }

        return dp[n];
    }
}


class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            int j = 1;
            // choose only perfect square numbers
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j++;
            }
        }

        return dp[n];
    }
}
