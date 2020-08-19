// [DP, BinarySearch]

/** Given an array which consists of non-negative integers and an integer m, you
  * can split the array into m non-empty continuous subarrays. Write an algorithm to
  * minimize the largest sum among these m subarrays.
  *
  * Note:
  * If n is the length of array, assume the following constraints are satisfied:
  *   1 ≤ n ≤ 1000
  *   1 ≤ m ≤ min(50, n)
  *
  * Examples:
  * Input:
  * nums = [7,2,5,10,8]
  * m = 2
  * Output:
  * 18
  *
  * Explanation:
  * There are four ways to split nums into two subarrays.
  * The best way is to split it into [7,2,5] and [10,8],
  * where the largest sum among the two subarrays is only 18.
  */

class Solution1 {
    // DP solution
    // dp(i, j) := largest subarray sum of nums[0, i] divided into j parts.
    // dp(i, j) := forall k, min(max(dp(k, j-1), sum(nums[k, i])))
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int[] sums = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        // prefix sum
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 0; k < i; k++) {
                    int sum = sums[i] - sums[k];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum));
                }
            }
        }

        return dp[n][m];
    }
}

class Solution2 {
    // binary search solution
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = 0;
        for (int n: nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int l = max, r = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int cap, int m) {
        int count = 1, sum = 0;
        for (int n: nums) {
            if (sum + n > cap) {
                count++;
                sum = n;
            } else {
                sum += n;
            }
            if (count > m) return false;
        }
        return count <= m;
    }
}
