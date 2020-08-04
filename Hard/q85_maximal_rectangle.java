// [DP]

/** Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
  * containing only 1's and return its area.
  *
  * Example:
    Input:
    [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]
    Output: 6
  */

class Solution {
    // dp[i][j] := longest consecutive of 1s in a row ending at (i, j)
    // this gives the width of possible rectangles.
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != '1') continue;
                dp[i][j] = j-1 >= 0 ? dp[i][j-1] + 1 : 1;
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '0') break;
                    // the minimum width is the threshold of rectangles
                    width = Math.min(width, dp[k][j]);
                    int area = width * (i - k + 1);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
}
