// [Stack, DP, Parenthesis] ***

/** Given a string containing just the characters '(' and ')', find the length of the
  * longest valid (well-formed) parentheses substring.
  *
  * Example 1:
  * Input: "(()"
  * Output: 2
  * Explanation: The longest valid parentheses substring is "()"
  *
  * Example 2:
  * Input: ")()())"
  * Output: 4
  * Explanation: The longest valid parentheses substring is "()()"
  *
  */

class Solution1 {

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {   // right parenthesis
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}


class Solution2 {

    // dp(i) := longest valid parentheses of substring s[0, i]
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(' || (s.charAt(i-1) == ')' && dp[i-1] == 0))
                continue;
            if (s.charAt(i-1) == '(') {
                dp[i] += 2;
                if (i-2 >= 0) dp[i] += dp[i-2];
            } else if (s.charAt(i-1) == ')' && i-dp[i-1]-1 >=0 && s.charAt(i-dp[i-1]-1) == '(') {
                dp[i] = dp[i-1] + 2;
                if (i-dp[i-1]-2 >= 0) dp[i] += dp[i-dp[i-1]-2];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
