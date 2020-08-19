// [DP]

/** Given a positive integer n, break it into the sum of at least two positive integers
  * and maximize the product of those integers. Return the maximum product you can get.
  *
  * Example 1:
  * Input: 2
  * Output: 1
  * Explanation: 2 = 1 + 1, 1 × 1 = 1.
  *
  * Example 2:
  * Input: 10
  * Output: 36
  * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
  *
  * Note: You may assume that n is not less than 2 and not larger than 58.
  */

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < dp.length; i++) {
            int j = 1;
            int k = i - 1;
            int val = 0;
            while (j <= k) {
                val = Math.max(val, Math.max(j, dp[j]) * Math.max(k, dp[k]));
                j++;
                k--;
            }
            dp[i] = val;
        }

        return dp[n];
    }
}
