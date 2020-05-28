// [DP]

/** A robot is located at the top-left corner of a m x n grid.
  * The robot can only move either down or right at any point in time. The robot
  * is trying to reach the bottom-right corner of the grid. Now consider if some
  * obstacles are added to the grids. How many unique paths would there be?
  *
  * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
  * m and n will be at most 100.
  *
  * Example:
  * Input: [[0,0,0], [0,1,0], [0,0,0]]
  * Output: 2
  */

class Solution {
    int[][] cache;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        cache = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            cache[0][0] = 0;
        } else {
            cache[0][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    cache[i][j] = 0;
                } else {
                    cache[i][j] = get(i-1, j) + get(i, j-1);
                }
            }
        }

        return cache[m-1][n-1];
    }

    private int get(int m, int n) {
        if (m < 0 || n < 0) return 0;
        return cache[m][n];
    }
}
