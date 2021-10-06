// [Backtracking]
class Solution {
    public void solveSudoku(char[][] board) {
       backtrack(board, 0, 0);
    }
    
    private boolean backtrack(char[][] board, int row, int col) {
        if (col >= 9) {
            col -= 9; row += 1;
        }
        if (row >= 9) return true;
        
        if (board[row][col] != '.') {
            return backtrack(board, row, col+1);
        }
        for (int i = 1; i < 10; i++) {
            char c = (char) ('0' + i);
            if (!check(board, row, col, c)) continue;
            board[row][col] = c;
            if (backtrack(board, row, col+1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }
    
    private boolean check(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row+i][col+j] == val) return false;
            }
        }
        return true;
    }
}
