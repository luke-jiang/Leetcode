// [DP]

/** Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
  * by its upper left corner (row1, col1) and lower right corner (row2, col2).
  *
  * Example:
  * Given matrix = [
    [3, 0, 1, 4, 2],
    [5, 6, 3, 2, 1],
    [1, 2, 0, 1, 5],
    [4, 1, 0, 1, 7],
    [1, 0, 3, 0, 5]
  ]

  * sumRegion(2, 1, 4, 3) -> 8
  * sumRegion(1, 1, 2, 2) -> 11
  * sumRegion(1, 2, 2, 4) -> 12
  *
  */

class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        if (m == 0) return;
        dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            int sum = 0;
            for (int j = 1; j < m+1; j++) {
                sum += matrix[i-1][j-1];
                dp[i][j] = dp[i-1][j] + sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
