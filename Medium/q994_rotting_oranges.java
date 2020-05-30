// [BFS]

/** In a given grid, each cell can have one of three values:
  *
  * the value 0 representing an empty cell;
  * the value 1 representing a fresh orange;
  * the value 2 representing a rotten orange.
  *
  * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten
  * orange becomes rotten.
  * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
  * If this is impossible, return -1 instead.
  *
  * Examples:
  * [[2,1,1],[1,1,0],[0,1,1]] -> 4
  * [[2,1,1],[0,1,1],[1,0,1]] -> -1
  * [[0,2]] -> 0 (because no fresh orange at minute 0)
  */

class Solution {

    public class Orange {
        int x;
        int y;
        int dist;       // DFS depth

        public Orange(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int orangesRotting(int[][] grid) {
        int fresh = 0;      // number of fresh oranges

        // BFS queue, initially stores all rotten oranges
        Queue<Orange> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    queue.add(new Orange(i, j, 0));
                }
            }
        }

        if (fresh == 0) return 0;
        if (queue.size() == 0) return -1;

        int level = 0;          // depth of BFS
        int traversed = 0;      // number of oranges traversed

        int x = grid.length;
        int y = grid[0].length;

        while (queue.size() > 0) {
            Orange o = queue.remove();
            int i = o.x;
            int j = o.y;
            int d = o.dist;
            level = Math.max(level, d);

            if (i < 0 || i >= x || j < 0 || j >= y || grid[i][j] == 0) continue;

            // increment traversed count if current orange is fresh
            if (grid[i][j] == 1) {
                traversed++;
            }

            // increment depth if current orange is fresh
            int newd = grid[i][j] == 1 ? d+1 : d;

            grid[i][j] = 0;
            queue.add(new Orange(i+1, j, newd));
            queue.add(new Orange(i-1, j, newd));
            queue.add(new Orange(i, j+1, newd));
            queue.add(new Orange(i, j-1, newd));

        }

        if (traversed < fresh) return -1;
        return level;
    }
}
