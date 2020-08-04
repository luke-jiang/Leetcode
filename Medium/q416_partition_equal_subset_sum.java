// [DP]

/** Given a non-empty array containing only positive integers, find if the array can be
  * partitioned into two subsets such that the sum of elements in both subsets is equal.
  *
  * Note:
  * Each of the array element will not exceed 100.
  * The array size will not exceed 200.
  *
  * Example 1:
  * Input: [1, 5, 11, 5]
  * Output: true
  * Explanation: The array can be partitioned as [1, 5, 5] and [11].
  *
  * Example 2:
  * Input: [1, 2, 3, 5]
  * Output: false
  * Explanation: The array cannot be partitioned into equal sum subsets.
  */

// KEY OBSERVATION:
// if the sum of nums is odd, then it's impossible to partition the array.
// if the sum of even, then each partitioned subset has half the sum.

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        int halfsum = sum / 2;

        // return true if there exists a subset whose sum == halfsum

        int n = nums.length;
        boolean[][] dp = new boolean[n][halfsum+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < halfsum+1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i-1 >= 0 && dp[i-1][j]) {
                    dp[i][j] = true;
                } else if (j == nums[i]) {
                    dp[i][j] = true;
                } else if (i-1 >= 0 && j - nums[i] >= 0) {
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][halfsum];
    }
}
