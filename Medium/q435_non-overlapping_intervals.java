// [Greedy] ***

/** Given a collection of intervals, find the minimum number of intervals you need
  * to remove to make the rest of the intervals non-overlapping.
  *
  * Example 1:
  * Input:      [[1,2],[2,3],[3,4],[1,3]]
  * Output:     1
  * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
  *
  * Example 2:
  * Input:      [[1,2],[1,2],[1,2]]
  * Output:     2
  * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
  *
  * Example 3:
  * Input:      [[1,2],[2,3]]
  * Output:     0
  * Explanation: You don't need to remove any of the intervals since they're already
    non-overlapping.
  *
  * Note:
  * You may assume the interval's end point is always bigger than its start point.
  * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
  *
  */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;

        if (len == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];
        int prev = 0;
        int count = 0;  // number of intervals to remove
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }

        return count;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;

        if (len == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return len - res;
    }
}
