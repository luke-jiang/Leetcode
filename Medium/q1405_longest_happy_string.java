// [Greedy]

/** A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
  * Given three integers a, b and c, return any string s, which satisfies following conditions:
  *     s is happy and longest possible.
  *     s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b'
        and at most c occurrences of the letter 'c'.
  *     s will only contain 'a', 'b' and 'c' letters.
  * If there is no such string s return the empty string "".
  *
  * Example 1:
  * Input: a = 1, b = 1, c = 7
  * Output: "ccaccbcc"
  * Explanation: "ccbccacc" would also be a correct answer.
  *
  * Example 2:
  * Input: a = 2, b = 2, c = 1
  * Output: "aabbc"
  *
  * Example 3:
  * Input: a = 7, b = 1, c = 0
  * Output: "aabaa"
  * Explanation: It's the only correct answer in this case.
  *
  * Constraints:
  * 0 <= a, b, c <= 100
  * a + b + c > 0
  */

class Solution {
    // greedily select the character with the maximum number.
    // If there are two consecutive max char at the end of current string,
    // select the second largest char.
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (a > 0 || b > 0 || c > 0) {
            boolean flagA = false;
            boolean flagB = false;
            boolean flagC = false;
            if (i >= 2 && sb.charAt(i-1) == sb.charAt(i-2)) {
                flagA = (sb.charAt(i-1) == 'a');
                flagB = (sb.charAt(i-1) == 'b');
                flagC = (sb.charAt(i-1) == 'c');
            }
            char next = getNext(a, b, c, flagA, flagB, flagC);
            if (next == '0') break;
            sb.append(next);
            i++;
            if (next == 'a') {
                a--;
            } else if (next == 'b') {
                b--;
            } else {
                c--;
            }

        }
        return sb.toString();
    }

    private char getNext(int a, int b, int c, boolean flagA, boolean flagB, boolean flagC) {
        if (flagA) a = 0;
        if (flagB) b = 0;
        if (flagC) c = 0;
        if (a >= b && a >= c && a > 0) return 'a';
        if (b >= a && b >= c && b > 0) return 'b';
        if (c >= a && c >= b && c > 0) return 'c';
        return '0';
    }
}
