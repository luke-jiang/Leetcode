/** Given two strings s and t , write a function to determine if t is an anagram of s.
  *
  * Example 1:
  * Input: s = "anagram", t = "nagaram"
  * Output: true
  *
  * Example 2:
  * Input: s = "rat", t = "car"
  * Output: false
  *
  * Note:
  * You may assume the string contains only lowercase alphabets.
  *
  * Follow up:
  * What if the inputs contain unicode characters? How would you adapt your
  * solution to such case?
  */

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) return false;
        for (int i = 0; i < slen; i++) {
            chars[s.charAt(i) - 'a']--;
            chars[t.charAt(i) - 'a']++;
        }
        for (int n : chars) {
            if (n != 0) return false;
        }
        return true;
    }
}

// save mem
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int n : freq) {
            if (n != 0) return false;
        }
        return true;
    }
}