// [SlidingWindow]

/** Given n non-negative integers a1, a2, ..., an , where each represents a point
  * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
  * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
  * forms a container, such that the container contains the most water.
  */

class Solution {
    public int maxArea(int[] height) {
        int from = 0, to = height.length - 1, result = 0;
        while (from < to) {
            result = Math.max(result, Math.min(height[from], height[to]) * (to - from));
            if (height[from] < height[to]) {
                from++;
            } else {
                to--;
            }

        }
        return result;
    }
}
