// [SlidingWindow + HashMap]

/** Given a string s , find the length of the longest substring t  that contains
  * at most 2 distinct characters.
  *
  * Example 1:
  * Input: "eceba"
  * Output: 3
  * Explanation: t is "ece" which its length is 3.
  *
  * Example 2:
  * Input: "ccaabbb"
  * Output: 5
  * Explanation: t is "aabbb" which its length is 5.
  */

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxlen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, right);

            if (map.size() > 2) {
                int min_idx = Collections.min(map.values());
                map.remove(s.charAt(min_idx));
                left = min_idx + 1;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }
}
