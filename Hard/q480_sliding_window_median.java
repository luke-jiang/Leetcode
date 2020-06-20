// [MedianHeap]

/** Median is the middle value in an ordered integer list. If the size of the list is even,
  * there is no middle value. So the median is the mean of the two middle value.
  *
  * Examples:
  * [2,3,4] , the median is 3
  * [2,3], the median is (2 + 3) / 2 = 2.5
  *
  * Given an array nums, there is a sliding window of size k which is moving from the
  * very left of the array to the very right. You can only see the k numbers in the window.
  * Each time the sliding window moves right by one position. Your job is to output the
  * median array for each window in the original array.
  *
  * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

    Window position                Median
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7       3
     1  3  -1  -3 [5  3  6] 7       5
     1  3  -1  -3  5 [3  6  7]      6

  * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
  *
  * Note:
  * You may assume k is always valid, ie: k is always smaller than input array's size for
  *   non-empty array.
  * Answers within 10^-5 of the actual value will be accepted as correct.
  */

class Solution {
    class MeanHeap {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MeanHeap() {
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            minHeap = new PriorityQueue<Integer>();
        }

        public void add(int n) {
            if (maxHeap.size() == 0 || n <= maxHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
            }
            rebalance();
        }

        public void remove(int n) {
            if (n <= maxHeap.peek()) {
                maxHeap.remove(n);
            } else {
                minHeap.remove(n);
            }
            rebalance();
        }

        private void rebalance() {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        public double getMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        MeanHeap h = new MeanHeap();

        double[] medians = new double[nums.length - k + 1];

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            h.add(nums[i]);
            if (i + 1 >= k) {
                medians[start] = h.getMedian();
                h.remove(nums[start]);
                start++;
            }
        }

        return medians;
    }
}
