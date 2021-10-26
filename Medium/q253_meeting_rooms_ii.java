// [Sorting, Heap]

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> endtimes = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (endtimes.size() > 0 && start >= endtimes.peek()) {
                endtimes.poll();
            }
            endtimes.add(end);
        }
        return endtimes.size();
    }
}
