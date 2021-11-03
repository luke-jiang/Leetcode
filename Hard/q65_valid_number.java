class Solution {
    public boolean isNumber(String s) {
        s = s.toLowerCase();
        int e = s.indexOf('e');
        if (e == -1) {
            return s.length() == 0 ? false : isDecimal(s) || isInteger(s);
        } else {
            String left = s.substring(0, e);
            if (left.length() == 0) return false;
            String right = s.substring(e+1);
            if (!isDecimal(left) && !isInteger(left)) return false;
            return right.length() == 0 ? false : isInteger(right);
        }
    }
    
    private boolean isDecimal(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        int dot = s.indexOf('.');
        if (dot == -1) return false;
        String left = s.substring(0, dot);
        String right = s.substring(dot+1);
        if (left.length() == 0 && right.length() == 0) return false;
        return isDigits(left) && isDigits(right);
    }
    
    private boolean isInteger(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        return s.length() == 0 ? false : isDigits(s);
    }
    
    private boolean isDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
