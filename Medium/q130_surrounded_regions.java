// [DFS]

/** Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
  * A region is captured by flipping all 'O's into 'X's in that surrounded region.
  *
  * Example:

      X X X X
      X O O X
      X X O X
      X O X X

  * After running your function, the board should be:

      X X X X
      X X X X
      X X X X
      X O X X
      
  * Explanation:
  * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
  * are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the
  * border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected
  * horizontally or vertically.
  */

class Solution {
    int x;
    int y;

    // DFS from the four edges of the board. Mark all reachable 'O's. These are
    // 'O's that are not surrounded by 'X's. The remaining 'O's are surrounded.
    public void solve(char[][] board) {
        x = board.length;
        if (x == 0) return;
        y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || i == x-1 || j == 0 || j == y-1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O' ) {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'I') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= x || j < 0 || j >= y) return;
        if (board[i][j] != 'O') return;

        board[i][j] = 'I';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
