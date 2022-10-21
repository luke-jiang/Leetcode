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

class Solution {
    // num := [0-9]+
    // term := (expr) | num
    // expr := expr + term | expr - term | term
    
    Queue<Character> q = new LinkedList<>();
    public int calculate(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') q.add(s.charAt(i));
        }
        return getExpr();
    }
    
    private int getExpr() {
        int res = getTerm();
        while (!q.isEmpty() && (q.peek() == '+' || q.peek() == '-')) {
            char op = q.poll();
            if (op == '+') {
                res = res + getTerm();
            } else {
                res = res - getTerm();
            }
        }
        return res;
    }
    
    private int getTerm() {
        // System.out.println(q);
        if (q.peek() == '(') {
            q.poll();
            int res = getExpr();
            q.poll();
            return res;
        } else {
            return getNum();
        }
    }
    
    private int getNum() {
        int res = 0;
        while (!q.isEmpty() && q.peek() >= '0' && q.peek() <= '9') {
            res = res * 10 + (q.poll() - '0');
        }
        return res;
    }
    
}
