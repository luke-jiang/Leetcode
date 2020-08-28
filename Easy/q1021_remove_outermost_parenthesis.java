
/** A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where
` * A and B are valid parentheses strings, and + represents string concatenation.
  * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
  *
  * A valid parentheses string S is primitive if it is nonempty, and there does not
  * exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
  *
  * Given a valid parentheses string S, consider its primitive decomposition:
  * S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
  *
  * Return S after removing the outermost parentheses of every primitive string in
  * the primitive decomposition of S.
  *
  * Example 1:
  * Input: "(()())(())"
  * Output: "()()()"
  * Explanation:
  * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
  * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
  *
  * Example 2:
  * Input: "(()())(())(()(()))"
  * Output: "()()()()(())"
  * Explanation:
  * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" +
  * "(())" + "(()(()))".
  * After removing outer parentheses of each part, this is "()()" + "()" + "()(())"
  * = "()()()()(())".
  *
  * Example 3:
  * Input: "()()"
  * Output: ""
  * Explanation:
  * The input string is "()()", with primitive decomposition "()" + "()".
  * After removing outer parentheses of each part, this is "" + "" = "".
  */

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        if (n == 0) return S;

        int[] count = new int[n];
        count[0] = 1;
        for (int i = 1; i < n; i++) {
            count[i] = count[i-1] + (S.charAt(i) == '(' ? 1 : -1);
        }

        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (count[j] != 0) j++;
            sb.append(S.substring(i+1, j));
            i = j + 1;
        }
        return sb.toString();
    }
}
