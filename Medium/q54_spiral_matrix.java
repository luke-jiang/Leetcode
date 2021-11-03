class Solution {
    public enum Direction {L, R, U, D};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int cycle = 0;
        Direction curr = Direction.R;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            Direction next = curr;
            switch (curr) {
                case R:
                    if (y < n - 1 - cycle)  next = Direction.R;
                    else                    next = Direction.D;
                    break;
                case D:
                    if (x < m - 1 - cycle)  next = Direction.D;
                    else                    next = Direction.L;
                    break;
                case L:
                    if (y > cycle)          next = Direction.L;
                    else                    next = Direction.U;
                    break;
                case U:
                    if (x > cycle + 1)      next = Direction.U;
                    else                  { next = Direction.R; cycle++; }
                    break;
            }
            switch (next) {
                case R: y++; break;
                case D: x++; break;
                case L: y--; break;
                case U: x--; break;
            }
            // System.out.println(next);
            curr = next;
        }
        return res;
    }
}
