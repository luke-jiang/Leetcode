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


class Solution {
    Queue<Character> q = new LinkedList<>();

    public int calculate(String s) {
        for (char c : s.toCharArray()) q.add(c);
        
        int left = getProd();
        while (!q.isEmpty() && (q.peek() == '+' || q.peek() == '-')) {
            char op = q.remove();
            int right = getProd();
            left = op == '+' ? left + right : left - right;
        }
        return left;
    }
    
    private int getInt() {
        while (!q.isEmpty() && q.peek() == ' ') q.remove(); // remove leading zeroes
        int res = 0;
        while (!q.isEmpty() && isDigit(q.peek())) {
            res = res * 10 + (q.remove() - '0');
        }
        while (!q.isEmpty() && q.peek() == ' ') q.remove(); // remove pending zeroes
        return res;
    }
    
    private int getProd() {
        int left = getInt();
        while (!q.isEmpty() && (q.peek() == '*' || q.peek() == '/')) {
            char op = q.remove();
            int right = getInt();
            left = op == '*' ? left * right : left / right;
        }
        return left;
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
