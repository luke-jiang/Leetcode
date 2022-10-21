class Solution {
    boolean[][] seen;
    int m;
    int n;
    
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!seen[i][j] && dfs(grid, i, j, grid[i][j])) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, char c) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != c) return false;
        if (seen[i][j]) return true;
        seen[i][j] = true;
        grid[i][j] = '-';
        boolean res = dfs(grid, i-1, j, c) ||  dfs(grid, i+1, j, c) || dfs(grid, i, j-1, c) || dfs(grid, i, j+1, c);
        grid[i][j] = c;
        return res;
    }
}
