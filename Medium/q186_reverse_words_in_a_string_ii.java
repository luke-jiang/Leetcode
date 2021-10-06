class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int from = 0;
        while (from < s.length) {
            int to = from + 1;
            while (to < s.length && s[to] != ' ') to++;
            reverse(s, from, to-1);
            from = to + 1;
        }
    }
    
    private void reverse(char[] s, int from, int to) {
        int mid = from + (to - from) / 2;
        int i = from;
        int j = to;
        while (from <= mid) {
            char tmp = s[from];
            s[from] = s[to];
            s[to] = tmp;
            from++;
            to--;
        }
    }
}
