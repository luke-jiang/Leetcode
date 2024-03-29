// [DP]

class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        int res = 1;
        for (int i = 2; i < n+1; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
