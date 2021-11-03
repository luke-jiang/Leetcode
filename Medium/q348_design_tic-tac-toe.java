class TicTacToe {
    // rows[i] / cols[i] stores the sum of each row / col.
    // the sum is incremented if player 1 puts a move, and decremented if play 2 puts a move
    int[] rows; 
    int[] cols;
    int diagonal;
    int antidiagonal;
    int len;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        len = n;
    }
    
    public int move(int row, int col, int player) {
        int p = (player == 1) ? 1 : -1; // player can be 1 or 2
        rows[row] += p;
        cols[col] += p;
        
        if (row == col) diagonal += p;
        if (col == len - row - 1) antidiagonal += p;
        
        if (Math.abs(rows[row]) == len ||
           Math.abs(cols[col]) == len ||
           Math.abs(diagonal) == len ||
           Math.abs(antidiagonal) == len) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
