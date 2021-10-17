/** The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
  * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
  * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

  * Each element of nums is in exactly one pair, and
  * The maximum pair sum is minimized.
  * Return the minimized maximum pair sum after optimally pairing up the elements.
  */

// INTUITION:
// To minimize the maximum pair sum, we should try to pair a big number with a small number

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[nums.length - i - 1]);
        }
        return ans;
    }
}
