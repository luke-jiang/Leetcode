// [Comparator, Heap]

/** Given a non-empty array of integers, return the k most frequent elements.
  * Example 1:
  * Input: nums = [1,1,1,2,2,3], k = 2
  * Output: [1,2]
  *
  * Example 2:
  * Input: nums = [1], k = 1
  * Output: [1]
  *
  * Note:
  * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
  * It's guaranteed that the answer is unique, in other words the set of the top k frequent
  *   elements is unique.
  * You can return the answer in any order.
  */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> freq.get(x) - freq.get(y));

        for (int key : freq.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int len = pq.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
