class Solution {
    public String makeFancyString(String s) {
        if (s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
        char x = s.charAt(0);
        char y = s.charAt(1);
        sb.append(x); sb.append(y);
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if (x == y && y == c) continue;
            sb.append(c);
            x = y;
            y = c;
        }
        return sb.toString();
    }
}
