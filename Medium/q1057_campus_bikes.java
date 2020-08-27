// [Greedy, BucketSort] ***

/** On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M.
  * Each worker and bike is a 2D coordinate on this grid.
  * Our goal is to assign a bike to each worker. Among the available bikes and workers,
  * we choose the (worker, bike) pair with the shortest Manhattan distance between each
  * other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs
  * with the same shortest Manhattan distance, we choose the pair with the smallest worker
  * index; if there are multiple ways to do that, we choose the pair with the smallest bike
  * index). We repeat this process until there are no available workers.
  *
  * The Manhattan distance between two points p1 and p2 is
  * Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
  *
  * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike
  * that the i-th worker is assigned to.
  *
  * Note:
  * 0 <= workers[i][j], bikes[i][j] < 1000
  * All worker and bike locations are distinct.
  * 1 <= workers.length <= bikes.length <= 1000
  */

// KEY OBSERVATION:
// Notice that the workers and bikes are drawn from bounded spaces. Therefore,
// the maximum value of possible bike-to-worker distances is known.
// Given that info, create a map that stores possible bike-worker pairs for
// each distance.

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        int w = workers.length;
        int b = bikes.length;

        boolean[] wo = new boolean[w];           // true if worker wo[i] is used
        boolean[] bi = new boolean[b];           // true if bike bi[i] is used
        List<int[]>[] dists = new List[2001];    // dist -> list(pair(worker, bike))

        int[] res = new int[w];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < b; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (dists[dist] == null) {
                    dists[dist] = new ArrayList<int[]>();
                }
                dists[dist].add(new int[]{i, j});
            }
        }

        for (int i = 0; i < 2001; i++) {
            if (dists[i] == null) continue;
            for (int[] pair : dists[i]) {
                int worker = pair[0];
                int bike = pair[1];
                if (!wo[worker] && !bi[bike]) {
                    res[worker] = bike;
                    wo[worker] = true;
                    bi[bike] = true;
                }
            }
        }
        return res;
    }
}
