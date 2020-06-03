
/** Given a collection of intervals, merge all overlapping intervals.
  *
  * input: [[1,3],[2,6],[8,10],[15,18]]
  * output: [[1,6],[8,10],[15,18]]
  *
  * Input: [[1,4],[4,5]]
  * Output: [[1,5]]
  */


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > res[j][1]) {
                j++;
                res[j] = intervals[i];
            } else {
                res[j][1] = Math.max(res[j][1], intervals[i][1]);
            }
        }

        return Arrays.copyOfRange(res, 0, j+1);
    }
}
