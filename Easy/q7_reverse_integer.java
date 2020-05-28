
/** Given a 32-bit signed integer, reverse digits of an integer.
  *
  * Examples:
  * 123 -> 321
  * -123 -> -321
  * 120 -> 21
  *
  * Note:
  * Assume we are dealing with an environment which could only store integers
  * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
  * of this problem, assume that your function returns 0 when the reversed integer
  * overflows.
  */

class Solution {
    // key is how to deal with overflow.
    public int reverse(int x) {
        boolean neg = x < 0;
        x = Math.abs(x);
        int res = 0;
        int limit = Integer.MAX_VALUE / 10; // 214748364
        int limd = neg ? 8 : 7;

        while (x > 0) {
            int old = res;
            int digit = x % 10;
            // detect overflow
            if (old > limit || (old == limit && digit > limd)) return 0;
            x = x / 10;
            res = res * 10 + digit;
        }

        return neg ? -res : res;
    }
}
