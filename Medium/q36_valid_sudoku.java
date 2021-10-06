class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList(9);
        List<Set<Character>> cols = new ArrayList(9);
        List<Set<Character>> sqrs = new ArrayList(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>(9));
            cols.add(new HashSet<>(9));
            sqrs.add(new HashSet<>(9));
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                int sqr = (row / 3) * 3 + (col / 3);
                
                if (rows.get(row).contains(c)) return false;
                rows.get(row).add(c);
                if (cols.get(col).contains(c)) return false;
                cols.get(col).add(c);
                if (sqrs.get(sqr).contains(c)) return false;
                sqrs.get(sqr).add(c);
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] sqrs = new boolean[9][10];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int n = board[i][j] - '0';
                if (rows[i][n]) return false;
                rows[i][n] = true;
                if (cols[j][n]) return false;
                cols[j][n] = true;
                
                int x = (i / 3) * 3 + (j / 3);
                if (sqrs[x][n]) return false;
                sqrs[x][n] = true;
            }
        }
        return true;
    }
}
