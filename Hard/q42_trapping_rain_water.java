// [Two pointers] **
/** Given n non-negative integers representing an elevation map where the width of each bar is 1, 
  * compute how much water it can trap after raining.
  *
  * Example 1:
  * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
  * Output: 6
  * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
  * In this case, 6 units of rain water (blue section) are being trapped.
  */

/** use `left` and `right` to mark the search boundary. `leftMax` and `rightMax` are two states
  * At each step, the amount of trapped water is determined by the smaller of two maxes. Therefore,
  * increment `ans` by the amount of water trapped at that step, which equals to the difference between
  * the maximum and the current height.
  */

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }
}
