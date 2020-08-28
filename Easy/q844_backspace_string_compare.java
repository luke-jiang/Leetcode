// [Stack]

/** Given two strings S and T, return if they are equal when both are typed into
  * empty text editors. # means a backspace character.
  *
  * Note that after backspacing an empty text, the text will continue empty.
  *
  * Example 1:
  * Input: S = "ab#c", T = "ad#c"
  * Output: true
  * Explanation: Both S and T become "ac".
  *
  * Example 2:
  * Input: S = "ab##", T = "c#d#"
  * Output: true
  * Explanation: Both S and T become "".
  *
  * Example 3:
  * Input: S = "a##c", T = "#a#c"
  * Output: true
  * Explanation: Both S and T become "c".
  *
  * Example 4:
  * Input: S = "a#c", T = "b"
  * Output: false
  * Explanation: S becomes "c" while T becomes "b".
  *
  * Note:
  * 1 <= S.length <= 200
  * 1 <= T.length <= 200
  * S and T only contain lowercase letters and '#' characters.
  */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#' && !s1.isEmpty()) {
                s1.pop();
            } else if (c != '#') {
                s1.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#' && !s2.isEmpty()) {
                s2.pop();
            } else if (c != '#') {
                s2.push(c);
            }
        }
        if (s1.size() != s2.size()) return false;
        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return true;
    }
}
