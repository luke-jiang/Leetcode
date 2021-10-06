// [DP] **

/** You are given an integer array coins representing coins of different denominations and 
  * an integer amount representing a total amount of money. Return the fewest number of coins 
  * that you need to make up that amount. If that amount of money cannot be made up by any 
  * combination of the coins, return -1.
  * You may assume that you have an infinite number of each kind of coin.
  *
  * Example 1:
  * Input: coins = [1,2,5], amount = 11
  * Output: 3
  * Explanation: 11 = 5 + 5 + 1
  *
  * Example 2:
  * Input: coins = [2], amount = 3
  * Output: -1
  */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int coin : coins) {
                int prev = i - coin;
                if (prev >= 0 && dp[prev] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+dp[prev]);
                }
            }
        }
        return dp[amount] < Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
