
/** Given a string s, find the longest palindromic substring in s.
  * You may assume that the maximum length of s is 1000.
  *
  * Examples:
  * "babad" -> "bab" || "aba"
  * "cbbd" -> "bb"
  * "abcda" -> "a"
  */
  
class Solution {
    int max;
    String substring;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;

        max = 1;
        substring = s.substring(0, 1);

        for (int i = 0; i < len; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }

        return substring;
    }

    private void expand(String s, int from, int to) {
        while (from >= 0 && to < s.length() && s.charAt(from) == s.charAt(to)) {
                from--; to++;
        }
        int len = Math.max(max, to-from-1);
        if (len > max) {
            max = len;
            substring = s.substring(from+1, to);
        }
    }
}
