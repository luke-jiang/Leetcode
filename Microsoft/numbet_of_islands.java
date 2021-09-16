class Solution {
    boolean[][] searched;
    int rows;
    int cols;
    
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int res = 0;
        searched = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0' || searched[i][j]) continue;
                expand(grid, i, j);
                res++;
            }
        }
        return res;
    }
    
    private void expand(char[][] grid, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        if (grid[i][j] == '0' || searched[i][j]) return;
        searched[i][j] = true;
        expand(grid, i+1, j);
        expand(grid, i-1, j);
        expand(grid, i, j+1);
        expand(grid, i, j-1);
    }
}
