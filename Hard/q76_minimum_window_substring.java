// [SlidingWindow]

/** Given a string S and a string T, find the minimum window in S which will contain
  * all the characters in T in complexity O(n).
  *
  * Example:
  * Input: S = "ADOBECODEBANC", T = "ABC"
  * Output: "BANC"
  *
  * Note:
  * If there is no such window in S that covers all characters in T, return the empty
  * string "".
  * If there is such window, you are guaranteed that there will always be only one
  * unique minimum window in S.
  */

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = map.size();
        int left = 0;           // left window pointer
        int right = 0;          // right window pointer
        int formed = 0;         // number of chars in current window whose frequency matches that in t

        Map<Character, Integer> windowCounts = new HashMap<>();

        // {length, left, right}
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            // add one char from the right of the window
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);

            if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // try and contract the window until the window is not desirable
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) -1);
                if (map.containsKey(c) && windowCounts.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}
