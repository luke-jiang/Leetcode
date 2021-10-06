class Solution {
    public int myAtoi(String s) {
        boolean positive = true;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length() && s.charAt(i) == '-') { 
            positive = false; i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        int prev = 0;
        int res = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
            if (res / 10 != prev) return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            prev = res;
            i++;
        }
        return positive ? res : -res;
    }
}
