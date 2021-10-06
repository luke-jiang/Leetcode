// [Sorting, Heap]

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> endtimes = new PriorityQueue<>();
        endtimes.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= endtimes.peek()) {
                endtimes.poll();
            }
            endtimes.add(end);
        }
        return endtimes.size();
    }
}
