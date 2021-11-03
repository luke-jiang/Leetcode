// [DP]
class Solution {
    public int fib(int n) {
        int[] dp = new int[Math.max(2, n+1)];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

class Solution {
    // reduce memory from O(n) to O(1)
    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = res;
        }
        return dp[1];
    }
}
