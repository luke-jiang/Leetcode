// [DP]

class Solution {
    // opt[i][j] := number of possible ways to row i dice with target j
    // opt[i][j] := sum of (forall 1 <= k <= f : dp[i-1][j-k])
    public int numRollsToTarget(int d, int f, int target) {
        int modulo = 1000000007;
        int[][] dp = new int[d+1][target+1];

        dp[0][0] = 1;
        for (int i = 0; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > i*f) continue;
                for (int k = 1; k <= Math.min(j, f); k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % modulo;
                }
            }
        }

        return dp[d][target];
    }
}
