// [DP]

/** Given an integer array nums, find the contiguous subarray (containing at least one number)
  * which has the largest sum and return its sum.
  *
  * Example:
  * Input: [-2,1,-3,4,-1,2,1,-5,4],
  * Output: 6
  * Explanation: [4,-1,2,1] has the largest sum = 6.
  *
  * Follow up:
  * If you have figured out the O(n) solution, try coding another solution using the
  * divide and conquer approach, which is more subtle.
  */

class Solution {
    // dp[i] is the sum of elements of the maximum subarray in nums[0, i]
    // under the constrain that nums[i] must be included in the subarray.
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int n : nums) {
            if (sum < 0) {
                sum = n;
            } else {
                sum += n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
