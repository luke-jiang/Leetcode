/** Given a string, determine if it is a palindrome, considering only alphanumeric
  * characters and ignoring cases.
  *
  * Note: For the purpose of this problem, we define empty string as valid palindrome.
  *
  * Example 1:
  * Input:      "A man, a plan, a canal: Panama"
  * Output:     true
  *
  * Example 2:
  * Input:      "race a car"
  * Output:     false
  */

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] str = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if ((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9')) {
                str[j] = x;
                j++;
            } else if (x >= 'A' && x <= 'Z') {
                str[j] = (char) (x - 'A' + 'a');
                j++;
            }
        }

        for (int i = 0, k = j-1; i < k; i++, k--) {
            if (str[i] != str[k]) {
                return false;
            }
        }
        return true;
    }
}
