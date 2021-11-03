// [Greedy]

/** Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
  * Each element in the array represents your maximum jump length at that position.
  * Your goal is to reach the last index in the minimum number of jumps.
  * You can assume that you can always reach the last index.
  *
  * Example 1:
  * Input: nums = [2,3,1,1,4]
  * Output: 2
  * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
  *
  * Example 2:
  * Input: nums = [2,3,0,1,4]
  * Output: 2
  */

class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxReach = 0;
        int res = 0;
        for (int i = 0; end < nums.length - 1; end = maxReach) {
            res++;
            while (i <= end) {
                maxReach = Math.max(maxReach, i + nums[i++]);
            }
            if (maxReach == end) return -1;
        }
        return res;
    }
}
