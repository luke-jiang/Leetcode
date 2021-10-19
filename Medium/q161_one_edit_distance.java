class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.equals(t)) return false;
        if (s.length() == 0) return t.length() == 1;
        if (t.length() == 0) return s.length() == 1;
        
        int i = 0;
        int j = 0;
        boolean mismatch = false;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else if (mismatch) {
                return false;
            } else {
                mismatch = true;
                if (s.length() == t.length()) {
                    i++; j++;
                } else if (s.length() < t.length()) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return true;
    }
}
