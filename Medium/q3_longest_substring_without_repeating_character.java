// [SlidingWindow + HashMap]

/** Given a string, find the length of the longest substring without repeating characters.
  *
  * Examples:
  * "abcabcbb" outputs 3 ("abc")
  * "bbbbb" outputs 1 ("b")
  * "pwwkew" outputs 3 ("wke")
  * "abba" outputs 2
  */

class Solution {
    // keeps track of all traversed characters and their most recent indices
    // also keeps track of the length of the current substring w/out repeating chars.
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int cache = 1;            // length of current substring
        int max = 1;              // length of longest substring
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // found repeating character, two cases:
                // if c is counted as part of current substring, the new substring
                // begins with the char following c. Else, c is a new char with respect
                // to current substring and we should increment cache by 1.
                int index = map.get(c);
                // cache = i - index;
                cache = Math.min(i - index, cache + 1);
            } else {
                // new character found, concatenate into current substring
                cache = cache + 1;
            }
            map.put(c, i);        // update map info
            max = Math.max(max, cache);
        }
        return max;
    }
}


class Solution {
    // sliding window of range[i, j)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                // update the beginning of the substring
                int index = map.get(s.charAt(j));
                i = Math.max(index, i);
            }
            max = Math.max(max, j - i + 1);
            map.put(c, j+1);
        }
        return max;
    }
}
