/** Given a positive integer n, generate a square matrix filled with elements from
  * 1 to n2 in spiral order.
  *
  * Input: 3
  * Output: [[1,2,3],
  *          [8,9,4],
  *          [7,6,5]]
  */

class Solution {
    public enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0;
        int y = -1;
        Direction curr = Direction.RIGHT;

        for (int i = 1; i <= n * n; i++) {
            switch (curr) {
                case RIGHT : y++; break;
                case DOWN  : x++; break;
                case LEFT  : y--; break;
                case UP    : x--; break;
            }
            res[x][y] = i;
            Direction next = curr;
            switch (curr) {
                case RIGHT :
                    if (y < n-1 && res[x][y+1] == 0) next = Direction.RIGHT;
                    else next = Direction.DOWN;
                    break;
                case DOWN :
                    if (x < n-1 && res[x+1][y] == 0) next = Direction.DOWN;
                    else next = Direction.LEFT;
                    break;
                case LEFT :
                    if (y > 0 && res[x][y-1] == 0) next = Direction.LEFT;
                    else next = Direction.UP;
                    break;
                case UP:
                    if (x > 0 && res[x-1][y] == 0) next = Direction.UP;
                    else next = Direction.RIGHT;
                    break;
            }
            curr = next;
        }
        return res;
    }
}
