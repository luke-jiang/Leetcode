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

class Solution {
    int M = 1000000007;
    Integer[][] dp;
    
    public int numRollsToTarget(int d, int f, int target) {
        dp = new Integer[d+1][target+1];
        return search(d, f, target);
    }
    
    private int search(int d, int f, int target) {
        if (target < d) {
            return 0;
        } else if (target == d) {
            return 1;
        } else if (d == 0) {
            return 0;
        } else if (dp[d][target] != null) {
            return dp[d][target];
        } else {
            dp[d][target] = 0;
            for (int i = 1; i <= f; i++) {
                dp[d][target] += search(d-1, f, target - i);
                dp[d][target] %= M;
            }
            return dp[d][target];
        }
    }
}
