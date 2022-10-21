class Solution {
    public String decodeString(String s) {
        String res = "";
        Queue<Character> str = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            str.add(s.charAt(i));
        }

        while (!str.isEmpty()) {
            res += parseFactor(str);
        }

        return res;
    }

    public int getNumber(Queue<Character> str) {
        int times = 0;
        while (!str.isEmpty()) {
            char next = str.peek();
            if (next >= '0' && next <= '9') {
                times = times * 10 + (next - '0');
                str.remove();
                next = str.peek();
            } else {
                break;
            }
        }
        return times;
    }

    public String getRegular(Queue<Character> str) {
        String res = "";
        while (!str.isEmpty()) {
            char next = str.peek();
            if (next != '[' && next != ']' && (next < '1' || next > '9')) {
                res += str.remove();
            } else {
                break;
            }
        }
        return res;
    }

    // factor := string num [ factor ]
    public String parseFactor(Queue<Character> str) {
        String res = getRegular(str);
        int times = getNumber(str);
        // System.out.println(times);
        if (times == 0) return res;

        str.remove(); // '['
        String substr = parseFactor(str);
        str.remove(); // ']'
        for (int i = 0; i < times; i++) {
            res += substr;
        }

        return res + parseFactor(str);
    }
}
