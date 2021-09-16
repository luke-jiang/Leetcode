class Solution {
    // rotate(T) <=> reverse(transpose(T))
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        // transpose
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // reverse by row
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < (len+1)/2; j++) {
                swap(matrix, i, j, i, len-1-j);
            }
        }
    }
    
    private void swap(int[][] matrix, int x, int y, int z, int w) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[z][w];
        matrix[z][w] = tmp;
    }
}
