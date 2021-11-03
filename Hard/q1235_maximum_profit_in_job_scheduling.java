// [Greedy]
class Solution {
    public class Schedule implements Comparable<Schedule> {
        int endTime;
        int profit;
        public Schedule(int endTime, int profit) {
            this.endTime = endTime; this.profit = profit;
        }
        // schedules are sorted by their endtime
        @Override
        public int compareTo(Schedule other) {
            return this.endTime - other.endTime;
        }
    }
    
    public class Job {
        int startTime;
        int endTime;
        int profit;
        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime; this.endTime = endTime; this.profit = profit;
        }
        public String toString() {
            return "(" + startTime + "," + endTime + "," + profit + ")";
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        // sort jobs by their start time
        Collections.sort(jobs, (i, j) -> i.startTime - j.startTime);
        
        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            Job currJob = jobs.get(i);
            // pop all appendable schedules, remember the maximum profit
            while (!pq.isEmpty() && currJob.startTime >= pq.peek().endTime) {
                maxProfit = Math.max(maxProfit, pq.peek().profit);
                pq.remove();
            }
            pq.add(new Schedule(currJob.endTime, maxProfit + currJob.profit));
        }
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek().profit);
            pq.remove();
        }
        return maxProfit;
    }
}
