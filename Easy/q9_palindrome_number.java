
/** Determine whether an integer is a palindrome. An integer is a palindrome
  * when it reads the same backward as forward.
  *
  * Examples:
  * 121 -> true
  * -121 -> false
  * 10 -> false
  */

class Solution {
    // find the reverse number of x and check if its equal to x.
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int z = 0;
        int y = x;
        for (; y >= 10; y /= 10) {
            z = z * 10 + y % 10;
        }
        z = z * 10 + y;

        return z == x;
    }
}
