/** Given a sorted array A of unique numbers, find the K-th missing number starting
  * from the leftmost number of the array.
  *
  * Example 1:
  * Input: A = [4,7,9,10], K = 1
  * Output: 5
  * Explanation: The first missing number is 5.
  *
  * Example 2:
  * Input: A = [4,7,9,10], K = 3
  * Output: 8
  * Explanation:
    The missing numbers are [5,6,8,...], hence the third missing number is 8.
  *
  * Example 3:
  * Input: A = [1,2,4], K = 3
  * Output: 6
  * Explanation:
    The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

  * Note:
  * 1 <= A.length <= 50000
  * 1 <= A[i] <= 1e7
  * 1 <= K <= 1e8
  */

class Solution {
    public int missingElement(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            int x = nums[i];
            int y = nums[i+1];

            for (int j = x + 1; j < y; j++) {
                k--;
                if (k == 0) return j;
            }
        }
        return nums[nums.length-1] + k;
    }
}

class Solution {
    // one-pass, optimized
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(n-1, nums)) {
            // the missing number is beyond the end of nums
            return nums[n-1] + k - missing(n-1, nums);
        }

        int idx = 1;
        while (missing(idx, nums) < k) idx++;
        // range(nums[0], nums[idx]) now has enough missing numbers
        return nums[idx-1] + k - missing(idx-1, nums);
    }

    // how many numbers are missing in range(nums[0], nums[idx])
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
}
