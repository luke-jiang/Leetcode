class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        seen[0][0] = true;

        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Pair<Integer, Integer> p = q.remove();
                if (p.getKey() == n-1 && p.getValue() == n-1) {
                    return level + 1;
                }
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        int x = p.getKey() + j;
                        int y = p.getValue() + k;
                        
                        if (x >= 0 && x < n && y >= 0 && y < n && !seen[x][y] && grid[x][y] == 0) {
                            seen[x][y] = true;
                            q.add(new Pair(x, y));
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
