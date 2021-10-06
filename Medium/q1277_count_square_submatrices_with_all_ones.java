// [DP]

class Solution {
    // dp[i][j] := number of subarrays whose bottom-right element is matrix[i][j]
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    if (dp[i-1][j-1] >= 1 && dp[i][j-1] >= 1 && dp[i-1][j] >= 1) {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
