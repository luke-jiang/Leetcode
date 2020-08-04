// [DP]

/** Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
  * adjacent numbers on the row below.
  */


class Solution {
    // dp[i] = minimum path sum from root to the ith element in current level.
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int [] dp1 = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);


        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int rsize = row.size();
            for (int j = 0; j < rsize; j++) {
                int c = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    c = Math.min(c, dp[j-1]);
                    dp[j-1] = 0; // clear previous cache
                }
                if (j < rsize - 1) {
                    c = Math.min(c, dp[j]);
                }

                dp1[j] = c + row.get(j);
            }
            int[] tmp = dp;
            dp = dp1;
            dp1 = tmp;
        }

        int min = dp[0];
        for (int i : dp) min = Math.min(i, min);
        return min;
    }
}
