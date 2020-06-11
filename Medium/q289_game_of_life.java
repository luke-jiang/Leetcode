/** According to the Wikipedia's article: "The Game of Life, also known simply as Life,
  * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
  *
  * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
  * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
  * following four rules (taken from the above Wikipedia article):
  *
  * - Any live cell with fewer than two live neighbors dies, as if caused by under-population.
  * - Any live cell with two or three live neighbors lives on to the next generation.
  * - Any live cell with more than three live neighbors dies, as if by over-population..
  * - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
  *
  * Write a function to compute the next state (after one update) of the board given its current
  * state. The next state is created by applying the above rules simultaneously to every cell in
  * he current state, where births and deaths occur simultaneously.
  *
  * Example:
  * Input:
  * [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
  * Output:
  * [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
  */


class Solution {
    // -1: killed cell, was live
    // -2: revived cell, was dead
    int a;
    int b;
    int[][] board;

    public void gameOfLife(int[][] board) {
        this.a = board.length;
        if (this.a == 0) return;
        this.b = board[0].length;
        this.board = board;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int sum = 0;
                sum += get(i-1, j);
                sum += get(i+1, j);
                sum += get(i, j-1);
                sum += get(i, j+1);
                sum += get(i-1, j-1);
                sum += get(i-1, j+1);
                sum += get(i+1, j-1);
                sum += get(i+1, j+1);
                if (this.board[i][j] == 0 && sum == 3) this.board[i][j] = -2;
                if (this.board[i][j] == 1 && sum < 2) this.board[i][j] = -1;
                if (this.board[i][j] == 1 && sum > 3) this.board[i][j] = -1;
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (this.board[i][j] == -1 || this.board[i][j] == 0) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int get(int x, int y) {
        if (x < 0 || x >= a || y < 0 || y >= b) return 0;
        int res = this.board[x][y];
        if (res == -1 || res == 1) return 1;
        else return 0;
    }
}
