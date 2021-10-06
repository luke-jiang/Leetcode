class Solution {
    boolean[][] seen;
    int m;
    int n;
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, seen, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, boolean[][] seen, int i, int j, String word, int idx) {
        if (idx >= word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || seen[i][j]) return false;
        if (word.charAt(idx) != board[i][j]) return false;
        seen[i][j] = true;
        boolean res = false;
        if (!res && search(board, seen, i+1, j, word, idx+1)) res = true;
        if (!res && search(board, seen, i-1, j, word, idx+1)) res = true;
        if (!res && search(board, seen, i, j+1, word, idx+1)) res = true;
        if (!res && search(board, seen, i, j-1, word, idx+1)) res = true;
        seen[i][j] = false;
        return res;
    }
}
