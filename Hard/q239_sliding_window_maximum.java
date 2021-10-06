// [SlidingWindow + Queue/Deque]

/** Given an array nums, there is a sliding window of size k which is moving from
  * the very left of the array to the very right. You can only see the k numbers
  * in the window. Each time the sliding window moves right by one position. Return
  * the max sliding window.
  *
  * Follow up:
  * Could you solve it in linear time?
  *
  * Example:
  * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
  * Output: [3,3,5,5,6,7]
  *
  * Explanation:

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7

  * Constraints:
  * 1 <= nums.length <= 10^5
  * -10^4 <= nums[i] <= 10^4
  * 1 <= k <= nums.length
  *
  */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}

class Solution {
    int[] nums;
    Deque<Integer> dq = new LinkedList<>();

    public void clean_deque(int i, int k) {
        if (!dq.isEmpty() && dq.getFirst() == i - k) {
            dq.removeFirst();
        }
        while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
            dq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        } else if (k == 1) {
            return nums;
        }

        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            dq.addLast(i);

            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }

        int[] res = new int[n - k + 1];
        res[0] = nums[max_idx];

        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            dq.addLast(i);
            res[i-k+1] = nums[dq.getFirst()];
        }

        return res;
    }
}

// Use a max heap to store maximum candidates. Before adding max to the result, check
// if the index of max is out of current window range
class Solution {
    
    class Element {
        int index;
        int value;
        
        public Element(int i, int v) {
            index = i;
            value = v;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> heap = new PriorityQueue<>((a, b) -> b.value - a.value);
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int i = 0;
        int j = 0;
        while (i < k) {
            heap.add(new Element(i, nums[i]));
            i++;
        }
        res[j++] = heap.peek().value;
        while (i < len) {
            // remove invalid maxes whose index are out of the current window
            while (!heap.isEmpty() && heap.peek().index <= i - k) heap.poll();
            heap.add(new Element(i, nums[i]));
            res[j++] = heap.peek().value;
            i++;
        }
        return res;
    }
}
