// [DP]

/** A frog is crossing a river. The river is divided into x units and at each unit
  * there may or may not exist a stone. The frog can jump on a stone, but it must not
  * jump into the water.
  *
  * Given a list of stones' positions (in units) in sorted ascending order, determine
  * if the frog is able to cross the river by landing on the last stone. Initially,
  * the frog is on the first stone and assume the first jump must be 1 unit.
  *
  * If the frog's last jump was k units, then its next jump must be either k - 1,
  * k, or k + 1 units. Note that the frog can only jump in the forward direction.
  *
  * Note:
  * The number of stones is ≥ 2 and is < 1,100.
  * Each stone's position will be a non-negative integer < 231.
  * The first stone's position is always 0.
  *
  * Example 1:
  * [0,1,3,5,6,8,12,17]
  * There are a total of 8 stones.
  * The first stone at the 0th unit, second stone at the 1st unit,
  * third stone at the 3rd unit, and so on...
  * The last stone at the 17th unit.
  *
  * Return true. The frog can jump to the last stone by jumping
  * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
  * 2 units to the 4th stone, then 3 units to the 6th stone,
  * 4 units to the 7th stone, and 5 units to the 8th stone.
  *
  * Example 2:
  * [0,1,2,3,4,8,9,11]
  * Return false. There is no way to jump to the last stone as
  * the gap between the 5th and 6th stone is too large.
  */

class Solution {
    int[][] dp;

    // dp(i, j) := true if the frog is currently at i-th stones and it is able to
    // reach the end with j units of jumps.
    // eventually return dp(0, 0).    // working backward
    // dp(n-1, j) = true forall j     // initialize the end position to be reachable for all steps
    // dp(i, j) = or { forall k in [i+1, end]; dp(k, stones[k] - stones[i]) }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = 1;
        }

        return search(stones, 0, 0) == 1;
    }

    private int search(int[] stones, int index, int k) {
        if (dp[index][k] != -1) {
            return dp[index][k];
        }
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if (gap >= k - 1 && gap <= k + 1) {
                if (search(stones, i, gap) == 1) {
                    dp[index][gap] = 1;
                    return 1;
                }
            }
        }

        dp[index][k] = 0;
        return dp[index][k];
    }
}
