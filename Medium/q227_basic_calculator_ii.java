// [Stack]

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        int n = s.length();
        char prev_op = '+';

        for (int i = 0; i <= n; i++) {
            char c = i == n ? 0 : s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else {
                if (prev_op == '+') {
                    st.push(currNum);
                } else if (prev_op == '-') {
                    st.push(-currNum);
                } else if (prev_op == '*') {
                    st.push(st.pop() * currNum);
                } else if (prev_op == '/') {
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                prev_op = c;
            }
        }

        int res = 0;
        for (int i : st) {
            res += i;
        }
        return res;
    }
}
