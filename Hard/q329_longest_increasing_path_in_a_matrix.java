class Solution {
    int m, n;
    int[][] cache;
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        cache = new int[m][n];
        int maxlen = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxlen = Math.max(maxlen, search(matrix, i, j, -1));
            }
        }
        return maxlen;
    }
    
    private int search(int[][] matrix, int i, int j, int prev) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prev) {
            return 0;
        }
        if (cache[i][j] > 0) return cache[i][j];
        
        int left    = search(matrix, i-1, j, matrix[i][j]);
        int right   = search(matrix, i+1, j, matrix[i][j]);
        int top     = search(matrix, i, j-1, matrix[i][j]);
        int bot     = search(matrix, i, j+1, matrix[i][j]);
        
        cache[i][j] = Math.max(Math.max(left, right), Math.max(top, bot)) + 1;
        return cache[i][j];
    }
}
