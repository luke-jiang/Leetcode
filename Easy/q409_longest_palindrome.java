/** Given a string which consists of lowercase or uppercase letters, find the length of
  * the longest palindromes that can be built with those letters.
  * This is case sensitive, for example "Aa" is not considered a palindrome here.
  *
  * Note:
  * Assume the length of given string will not exceed 1,010.
  *
  * Example:
  * Input:    "abccccdd"
  * Output:   7
  * Explanation:
  * One longest palindrome that can be built is "dccaccd", whose length is 7.
  */

class Solution {
    // keep track of the frequency of each character.
    // if a char c has 2 occurences, then it's possible to add the two chars
    // on both side of a palindromic string to get a new palindromic string.
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = 0;
        for (char c: s.toCharArray()) {
            count[c]++;
            if (count[c] == 2){
                length += 2;
                count[c] = 0;
            }
        }
        return (length == s.length()) ? length : length+1;
    }
}
