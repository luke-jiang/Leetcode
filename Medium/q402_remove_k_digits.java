// [String, Greedy]

/** Given a non-negative integer num represented as a string, remove k digits from the number
  * so that the new number is the smallest possible.
  *
  * Note:
  * The length of num is less than 10002 and will be ≥ k.
  * The given num does not contain any leading zero.
  *
  * Example 1:
  * Input: num = "1432219", k = 3
  * Output: "1219"
  * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is
  * the smallest.
  *
  * Example 2:
  * Input: num = "10200", k = 1
  * Output: "200"
  * Explanation: Remove the leading 1 and the number is 200. Note that the output must not
  *   contain leading zeroes.
  *
  * Example 3:
  * Input: num = "10", k = 2
  * Output: "0"
  * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
  */
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j+1)) j++;
            sb.deleteCharAt(j);
            while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0); // remove leadinf zeroes
            if (sb.length() == 0) return "0";
        }
        return sb.toString();
    }
}

class Solution {
    // from the highest digit to the lowest, greedily removing the digit which is
    // greater than its subsequent digit.
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        StringBuilder sb = new StringBuilder(num);
        sb.append('0');
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) > sb.charAt(j+1)) {
                    sb.deleteCharAt(j);
                    break;
                }
            }
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
}
