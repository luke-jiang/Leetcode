// [DP] ***

/** Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
  * on it represented by array nums. You are asked to burst all the balloons. If
  * the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
  * Here left and right are adjacent indices of i. After the burst, the left and right
  * then becomes adjacent.
  *
  * Find the maximum coins you can collect by bursting the balloons wisely.
  * Note:
  * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not
  * burst them.
  * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
  */

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n][n];

        return search(dp, newNums, 0, n-1);
    }

    public int search(int[][] dp, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        } else {
            int ans = 0;
            for (int i = left+1; i < right; i++) {
                int sum = nums[left] * nums[i] * nums[right] + search(dp, nums, left, i) +
                    search(dp, nums, i, right);
                ans = Math.max(ans, sum);
            }
            dp[left][right] = ans;
            return ans;
        }
    }
}
