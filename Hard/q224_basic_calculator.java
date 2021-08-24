class Solution {

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int sign = 1;
        st.push(1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                st.push(st.peek() * sign);
                sign = 1;
            } else if (c == ')') {
                st.pop();
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else {
                int tmp = c - '0';
                while (i+1 < s.length() && isDigit(s.charAt(i+1))) {
                    tmp = tmp * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                res += sign * st.peek() * tmp;
            }
        }
        return res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
