// [SlidingWindow + HashMap]

/** Given a string, find the length of the longest substring T that contains at most
  * k distinct characters.
  *
  * Example 1:
  * Input: s = "eceba", k = 2
  * Output: 3
  * Explanation: T is "ece" which its length is 3.
  *
  * Example 2:
  * Input: s = "aa", k = 1
  * Output: 2
  * Explanation: T is "aa" which its length is 2.
  */


class Solution {
    // keep a map of current chars in the window, and their rightmost indices.
    // if the window has size > k, move the left pointer to the next of the lowest
    // index in the map.
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n == 0 || k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxlen = 1;

        while (right < n) {
            map.put(s.charAt(right), right);

            if (map.size() == k + 1) {
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }
}
