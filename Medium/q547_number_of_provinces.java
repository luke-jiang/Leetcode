class Solution {
    boolean[] seen;
    int n;
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        n = isConnected.length;
        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int[][] isConnected, int i) {
        if (seen[i]) return;
        seen[i] = true;
        for (int j = 0; j < n; j++) {
            if (j != i && isConnected[i][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}
