// [Comparator, Heap]

/** Given a non-empty list of words, return the k most frequent elements.
  * Your answer should be sorted by frequency from highest to lowest. If two words
  * have the same frequency, then the word with the lower alphabetical order comes first.
  *
  * Example 1:
  * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
  * Output: ["i", "love"]
  * Explanation: "i" and "love" are the two most frequent words.
  *   Note that "i" comes before "love" due to a lower alphabetical order.
  *
  * Example 2:
  * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
  * Output: ["the", "is", "sunny", "day"]
  * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
  *   with the number of occurrence being 4, 3, 2 and 1 respectively.
  *
  * Note:
  * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  * Input words contain only lowercase letters.
  *
  * Follow up:
  * Try to solve it in O(n log k) time and O(n) extra space.
  */

class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) :
            count.get(w1) - count.get(w2)
        );
        for (String word : count.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}

class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (a.getValue() != b.getValue()) ? a.getValue() - b.getValue() :
            b.getKey().compareTo(a.getKey())
        );
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            pq.add(pair);
            if (pq.size() > k) pq.poll();
        }
        List<String> res = new ArrayList<>();
        while (pq.size() > 0) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}
