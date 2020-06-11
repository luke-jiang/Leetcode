// [SlidingWindow]

/** Given an array of n positive integers and a positive integer s, find the minimal
  * length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
  *
  * Example:
  * Input: s = 7, nums = [2,3,1,2,4,3]
  * Output: 2
  * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
  */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int from = 0;   // [from, i] defines the current subarray in consideration
        int sum = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                // move from to right as much as possible
                len = Math.min(len, i - from + 1);
                sum -= nums[from];
                from++;
            }
        }

        return len < Integer.MAX_VALUE ? len : 0;
    }
}
