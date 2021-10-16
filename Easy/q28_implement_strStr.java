/** Implement strStr().
  * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  *
  * Clarification:
  * What should we return when needle is an empty string? This is a great question to ask during an interview.
  * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
  */

class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) return 0;
        if (len1 < len2) return -1;
        for (int i = 0; i < len1 - len2 + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            if (haystack.substring(i, i+len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
