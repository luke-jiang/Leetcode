// [Two Pointers]

/** Given an array nums of n integers and an integer target, find three integers
  * in nums such that the sum is closest to target. Return the sum of the three
  * integers. You may assume that each input would have exactly one solution.
  *
  * Example 1:
  * Input: nums = [-1,2,1,-4], target = 1
  * Output: 2
  * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  *
  * Constraints:
  * 3 <= nums.length <= 10^3
  * -10^3 <= nums[i] <= 10^3
  * -10^4 <= target <= 10^4
  */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    low++;
                } else  {
                    high--;
                }
            }

            if (diff == 0) break;
        }

        return target - diff;
    }
}
