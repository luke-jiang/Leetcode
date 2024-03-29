// [DFS] CANONOCAL

/** Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
  * An island is surrounded by water and is formed by connecting adjacent lands horizontally
  * or vertically. You may assume all four edges of the grid are all surrounded by water.
  *
  * Example 1:
  * Input:
  *         11110
  *         11010
  *         11000
  *         00000
  * Output: 1
  *
  * Example 2:
  * Input:
  *         11000
  *         11000
  *         00100
  *         00011
  * Output: 3
  */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j] == '1') {
            dfs(grid, i-1, j);
        }
        if (i < grid.length - 1 && grid[i+1][j] == '1') {
            dfs(grid, i+1, j);
        }
        if (j > 0 && grid[i][j-1] == '1') {
            dfs(grid, i, j-1);
        }
        if (j < grid[0].length - 1 && grid[i][j+1] == '1') {
            dfs(grid, i, j+1);
        }
    }
}


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
