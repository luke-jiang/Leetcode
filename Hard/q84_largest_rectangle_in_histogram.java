
/** Given n non-negative integers representing the histogram's bar height where the
  * width of each bar is 1, find the area of largest rectangle in the histogram.
  *
  * Example:
  * heights = [2,1,5,6,2,3], return 10 (column 5 and 6)
  */

class Solution {
    // divide-and-conquer:
    // the maximum area is limited by the shortest column.
    // So, the maximum area is the max of
    // - max area of the left region to the shortest column
    // - max area of the right region to the shortest column
    // - max area limitedby the shortes column
    
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length-1);
    }

    private int helper(int[] heights, int from, int to) {
        if (from > to) return 0;
        int min = from;
        for (int i = from; i <= to; i++) {
            if (heights[i] < heights[min]) min = i;
        }
        int leftRegion = helper(heights, from, min-1);
        int rightRegion = helper(heights, min+1, to);
        return Math.max((to-from+1) * heights[min], Math.max(leftRegion, rightRegion));
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        Deque<Integer> s = new ArrayDeque();
        int ans = 0;

        for (int i = 0; i <= len; i++) {
            int h = (i == len) ? 0 : heights[i];
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int left_bound_height = heights[s.pop()];
                int width = (s.isEmpty()) ? i : i - 1 - s.peek();
                int curr_area = left_bound_height * width;
                ans = Math.max(ans, curr_area);
                i--;
            }
        }

        return ans;
    }
}
