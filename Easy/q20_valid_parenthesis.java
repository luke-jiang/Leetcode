// [Stack]

/** Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
  * determine if the input string is valid.
  *
  * An input string is valid if:
  * Open brackets must be closed by the same type of brackets.
  * Open brackets must be closed in the correct order.
  * Note that an empty string is also considered valid.
  *
  * Example 1:
  * Input: "()"
  * Output: true
  *
  * Example 2:
  * Input: "()[]{}"
  * Output: true
  *
  * Example 3:
  * Input: "(]"
  * Output: false
  *
  */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (st.isEmpty()) {
                return false;
            } else {
                Character prev = st.pop();
                if (c == ')' && prev != '(') {
                    return false;
                } else if (c == ']' && prev != '[') {
                    return false;
                } else if (c == '}' && prev != '{') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        char[] cache = new char[s.length()];
        int len = 0;

        for (int j = 0; j < s.length(); j++) {
            char i = s.charAt(j);

            if (i == '(' || i == '{' || i == '[') {
                cache[len] = i;
                len++;
            } else if (i == ']' && len > 0 && cache[len-1] == '[') {
                len--;
            } else if (i == '}' && len > 0 && cache[len-1] == '{') {
                len--;
            } else if (i == ')' && len > 0 && cache[len-1] == '(') {
                len--;
            } else {
                return false;
            }


        }

        return len == 0;
    }
}
