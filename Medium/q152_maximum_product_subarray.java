// [DP]

/** Given an integer array nums, find the contiguous subarray within an array
  * (containing at least one number) which has the largest product.
  *
  * Example 1:
  * Input: [2,3,-2,4]
  * Output: 6
  * Explanation: [2,3] has the largest product 6.
  *
  * Example 2:
  * Input: [-2,0,-1]
  * Output: 0
  * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
  */

class Solution {
    // max(i) := max product of nums[0, i]
    // min(i) := min product of nums[0. i]
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxs = new int[n];
        int[] mins = new int[n];
        maxs[0] = nums[0];
        mins[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                mins[i] = Math.min(maxs[i-1] * nums[i], nums[i]);
                maxs[i] = Math.max(mins[i-1] * nums[i], nums[i]);
            } else {
                mins[i] = Math.min(mins[i-1] * nums[i], nums[i]);
                maxs[i] = Math.max(maxs[i-1] * nums[i], nums[i]);
            }
            if (maxs[i] > max) {
                max = maxs[i];
            }
        }

        return max;
    }
}
