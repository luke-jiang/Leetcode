// [Greedy]

/** There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
  * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
  * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
  * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
  */
class Solution {
    public int minTaps(int n, int[] ranges) {
        // construct new arr s.t. arr[i] stores the watering range starting from i
        int[] arr = new int[n+1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]); // the start of the range cannot be smaller than 0
            arr[left] = Math.max(arr[left], i + ranges[i]); // always choose the longest range for each range starting at i
        }
        
        // like jump game ii
        int end = 0;
        int farCanReach = 0;
        int res = 0;
        for (int i = 0; i < arr.length && end < n; end = farCanReach) {
            res++;
            // find the maximum extend of all intervals starting in interval i
            while (i < arr.length && i <= end) {
                farCanReach = Math.max(farCanReach, arr[i++]);
            }
            if (end == farCanReach) return -1; // no interval to cover area after end
        }
        return res;
    }
}
