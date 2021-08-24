// [Queue-Parsing]

/** Given a balanced parentheses string S, compute the score of the string based on
  * the following rule:
  * () has score 1
  * AB has score A + B, where A and B are balanced parentheses strings.
  * (A) has score 2 * A, where A is a balanced parentheses string.
  *
  * Example 1:
  * Input: "()"
  * Output: 1
  *
  * Example 2:
  * Input: "(())"
  * Output: 2
  *
  * Example 3:
  * Input: "()()"
  * Output: 2
  *
  * Example 4:
  * Input: "(()(()))"
  * Output: 6
  *
  * Note:
  * S is a balanced parentheses string, containing only ( and ).
  * 2 <= S.length <= 50
  */

class Solution {
    public int scoreOfParentheses(String S) {
        return parseParallel(S, 0, S.length() - 1);
    }

    private int parseParallel(String S, int from, int to) {
        if (from >= to) return 0;
        int c = 1;
        int i = from + 1;
        for (; i < to; i++) {
            if (S.charAt(i) == '(') {
                c++;
            } else {
                c--;
            }
            if (c == 0) break;
        }
        return parseInside(S, from, i) + parseParallel(S, i+1, to);
    }

    private int parseInside(String S, int from, int to) {
        if (from >= to) {
            return 0;
        } else if (from + 1 == to) {
            return 1;
        } else {
            return 2 * parseParallel(S, from+1, to-1);
        }
    }
}
