// [DP]

/** You are given coins of different denominations and a total amount of money.
  * Write a function to compute the number of combinations that make up that amount.
  * You may assume that you have infinite number of each kind of coin.
  *
  * Example 1:
  * Input: amount = 5, coins = [1, 2, 5]
  * Output: 4
  * Explanation: there are four ways to make up the amount:
      5=5
      5=2+2+1
      5=2+1+1+1
      5=1+1+1+1+1
  *
  * Example 2:
  * Input: amount = 3, coins = [2]
  * Output: 0
  * Explanation: the amount of 3 cannot be made up just with coins of 2.
  *
  * Example 3:
  * Input: amount = 10, coins = [10]
  * Output: 1
  *
  * Note:
  * You can assume that
  *   0 <= amount <= 5000
  *   1 <= coin <= 5000
  *   the number of coins is less than 500
  *   the answer is guaranteed to fit into signed 32-bit integer
  */

class Solution {
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("]");
        }
    }

    public int change(int amount, int[] coins) {
        int x = coins.length;
        int y = amount + 1;

        if (amount == 0) return 1;
        if (x == 0) return 0;


        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            int c = coins[i];
            if (c < y) {
                dp[i][c] = 1;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 1; j < y; j++) {
                int denom = coins[i];
                int prev = j - denom;
                if (i-1 >= 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if (prev >= 0) {
                    dp[i][j] += dp[i][prev];
                }
            }
        }

        return dp[x-1][y-1];
    }
}
