// [SlidingWindow + Queue]

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
