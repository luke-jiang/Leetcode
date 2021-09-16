// [DP]

class Solution {
    public int numDecodings(String s) {
        int len = s.length()+1;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < len; i++) {
            if (s.charAt(i-1) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i-1];
            }
            int x = Integer.parseInt(s.substring(i-2, i));

            if (x <= 26 && x >= 10) {
                // System.out.println("true");
                dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }
}

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < n+1; i++) {
            int curr = s.charAt(i-1) - '0';
            if (curr != 0) {
                dp[i] += dp[i-1];
            }
            int prev = s.charAt(i-2) - '0';
            prev = prev * 10 + curr;
            if (prev >= 10 && prev <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
