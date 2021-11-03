// [DP]


class Solution {
    int[][] dp;

    public boolean isMatch(String text, String pattern) {
        dp = new int[text.length()+1][pattern.length()+1];
        return search(text, 0, pattern, 0);
    }
    
    private boolean search(String t, int i, String p, int j) {
        if (dp[i][j] != 0) return dp[i][j] == 1;
        boolean res = false;
        if (j == p.length()) {
            res = i == t.length();
        } else {
            boolean m = i < t.length() && (t.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                res = search(t, i, p, j+2) || (m && search(t, i+1, p, j));
            } else {
                res = m && search(t, i+1, p, j+1);
            }
        }
        dp[i][j] = res ? 1 : -1;
        return res;
    }
}

class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length()][p.length()];
        return match(s, 0, p, 0);
    }
    
    private boolean match(String s, int i, String p, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (j >= p.length()) {
            return false;
        } else if (i >= s.length()) {
            return j+1 < p.length() && p.charAt(j+1) == '*' && match(s, i, p, j+2);
        } else {
            if (dp[i][j] != 0) return dp[i][j] == 1;
            boolean res = false;
            boolean m = p.charAt(j) == '.' || p.charAt(j) == s.charAt(i);
            if (j+1 < p.length() && p.charAt(j+1) == '*') {
                res = match(s, i, p, j+2) || (m && match(s, i+1, p, j));
            } else {
                res = m && match(s, i+1, p, j+1);
            }
            dp[i][j] = res ? 1 : -1;
            return res;
        }
    }
}

// recursive solution
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean m = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (m && isMatch(s.substring(1), p));
        } else {
            return m && isMatch(s.substring(1), p.substring(1));
        }
    }
}
