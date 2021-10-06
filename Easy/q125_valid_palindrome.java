// [ReductionSearch]

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

// one-pass solution
class Solution {
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    private boolean isCapitalLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char p = s.charAt(i);
            char q = s.charAt(j);
            if (isCapitalLetter(p)) {
                p = (char) (p - 'A' + 'a');
            }
            if (isCapitalLetter(q)) {
                q = (char) (q - 'A' + 'a');
            }
            if (!isAlphaNumeric(p)) {
                i++; continue;
            }
            if (!isAlphaNumeric(q)) {
                j--; continue;
            }
            if (p != q) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
