// [BinarySearch]

/** Write an efficient algorithm that searches for a value in an m x n matrix.
  * This matrix has the following properties:
  * Integers in each row are sorted in ascending from left to right.
  * Integers in each column are sorted in ascending from top to bottom.
  * Example:
  * Consider the following matrix:
      [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
      ]
  * Given target = 5, return true.
  * Given target = 20, return false.
  */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length-1;
        while (row != matrix.length && col != matrix[0].length && row >= 0 && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r1 = 0;
        int r2 = m-1;
        int c1 = 0;
        int c2 = n-1;
        while (r1 <= r2 && c1 <= c2) {
            if (matrix[r1][c1] == target || matrix[r1][c2] == target || matrix[r2][c1] == target || matrix[r2][c2] == target) {
                return true;
            }
            // reduce r1, r2;
            while (r1 < m && matrix[r1][c2] < target) r1++;
            while (r2 >= 0 && matrix[r2][c1] > target) r2--;
            if (r1 >= m || r2 < 0) return false;
            while (c1 < n && matrix[r2][c1] < target) c1++;
            while (c2 >= 0 && matrix[r1][c2] > target) c2--;
            if (c1 >= n || c2 < 0) return false;
            
        }
        return false;
    }
}
