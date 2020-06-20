/** Given a string, find the first non-repeating character in it and return it's index.
  * If it doesn't exist, return -1.
  *
  * Examples:
  * s = "leetcode", return 0.
  * s = "loveleetcode", return 2.
  *
  * Note: You may assume the string contain only lowercase English letters.
  */

class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1) return i;
        }
        return -1;
    }
}
