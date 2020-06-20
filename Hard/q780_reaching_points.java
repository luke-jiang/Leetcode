// [Modulo, Recursion] ***

/** A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
  * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a
  * sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.
  *
  * Examples:
  * Input:        sx = 1, sy = 1, tx = 3, ty = 5
  * Output:       True
  * Explanation:
  * One series of moves that transforms the starting point to the target is:
  *     (1, 1) -> (1, 2)
  *     (1, 2) -> (3, 2)
  *     (3, 2) -> (3, 5)
  *
  * Input:        sx = 1, sy = 1, tx = 2, ty = 2
  * Output:       False
  *
  * Input:        sx = 1, sy = 1, tx = 1, ty = 1
  * Output:       True
  *
  * Note:
  * sx, sy, tx, ty will all be integers in the range [1, 10^9].
  */

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) return false;
        if (tx == sx && (ty - sy) % sx == 0) return true;
        if (ty == sy && (tx - sx) % sy == 0) return true;
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}
