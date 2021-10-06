class Solution {
    int n;
    int m;
    int origin;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        origin = image[sr][sc];
        dfs(image, sr, sc, newColor);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] < 0) image[i][j] = -image[i][j];
            }
        }
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int newColor) {
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (image[row][col] < 0 || image[row][col] != origin) return;
        // System.out.println(row + ", " + col);
        image[row][col] = -newColor;
        dfs(image, row-1, col, newColor);
        dfs(image, row+1, col, newColor);
        dfs(image, row, col-1, newColor);
        dfs(image, row, col+1, newColor);
    }
}
