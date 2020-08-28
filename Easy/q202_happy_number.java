/** Write an algorithm to determine if a number n is "happy".
  * A happy number is a number defined by the following process: Starting with any
  * positive integer, replace the number by the sum of the squares of its digits,
  * and repeat the process until the number equals 1 (where it will stay), or it
  * loops endlessly in a cycle which does not include 1. Those numbers for which
  * this process ends in 1 are happy numbers.
  *
  * Return True if n is a happy number, and False if not.
  *
  * Example:
  * Input: 19
  * Output: true
  * Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
  */


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> found = new HashSet<>();
        while (n != 1 && !found.contains(n)) {
            found.add(n);
            int n1 = 0;
            while (n > 0) {
                n1 += (n % 10) * (n % 10);
                n /= 10;
            }
            n = n1;
        }
        return n == 1;
    }
}
