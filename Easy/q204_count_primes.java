// [DP, Math] ***

/** Count the number of prime numbers less than a non-negative number, n.
  * Example:
  * Input: 10
  * Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */

  class Solution {
      public int countPrimes(int n) {
          if (n <= 1) {
              return 0;
          }
          // dp[i] = true iff i is NOT a prime number.
          boolean[] dp = new boolean[n];
          dp[0] = true;
          dp[1] = true;

          for (int i = 2; i < Math.sqrt(n); i++) {
              if (!dp[i]) {
                  for (int j = 2; i * j < n; j++) {
                      dp[i*j] = true;
                  }
              }
          }

          int count = 0;
          for (int i = 2; i < dp.length; i++) {
              if (!dp[i]) count++;
          }

          return count;

      }
  }
