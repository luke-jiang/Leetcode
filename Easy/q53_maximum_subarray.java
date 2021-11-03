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
    // dp[i] is the sum of elements of the maximum subarray ending at index i.
    // * recurrence relation:
    // dp[i] = dp[i-1] + nums[i]        if dp[i-1] >= 0
    //       | nums[i]                  else
    // * initial condition:
    // dp[0] = nums[0]

    // result is max { dp[i] }

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
    // Note that dp[i] only requires knowing dp[i-1], so we can reduce the O(n) dp array
    // into a single `prev` of size O(1):
    // a.k.a Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int prev = nums[0];
        int res = prev;
        for (int i = 1; i < nums.length; i++) {
            if (prev >= 0) {
                prev += nums[i];
            } else {
                prev = nums[i];
            }
            res = Math.max(res, prev);
        }
        return res;
    }
}
