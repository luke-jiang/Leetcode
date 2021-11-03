class Solution {
    // two pointers
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) i++;
            if (i == s.length()) return true;
        }
        return false;
    }
}

class Solution {
    // value map
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        
        int i = -1;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) return false;
            boolean match = false;
            for (int j : map.get(c)) {
                if (i < j) {
                    i = j;
                    match = true;
                    break;
                }
            }
            if (!match) return false;
        }
        
        return true;
    }
}

class Solution {
    // DP
    // * DP definition:
    // dp(i, j) := true iff s[i] is a subsequence of t[j]
    // * recurrence relation:
    // dp(i, j) = dp(i-1, j-1)          if s[i] == t[j]
    //          | dp(i, j-1)            else
    // * initial condition:
    // forall j, dp(0, j) = true
    // forall i != 0, dp(i, 0) = false
    // * return value:
    // dp(s.len-1, t.len-1)
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        if (slen == 0) return true;
        int tlen = t.length();
        boolean[][] dp = new boolean[slen+1][tlen+1];
        for (int i = 0; i <= tlen; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[slen][tlen];
    }
}
