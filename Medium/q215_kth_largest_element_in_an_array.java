class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> i - j);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}