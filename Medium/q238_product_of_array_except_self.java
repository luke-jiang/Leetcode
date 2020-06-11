// [Caching, PrefixArray]

/** Given an array nums of n integers where n > 1,  return an array output such
  * that output[i] is equal to the product of all the elements of nums except
  * nums[i].
  *
  * Example:
  * [1,2,3,4] -> [24,12,8,6]
  *
  * Constraint:
  * O(n) runtime, solve without division
  */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // tmp[i] stores nums[i] * nums[i+1] * ... * nums[len-1]
        int[] tmp = new int[nums.length];

        tmp[nums.length-1] = nums[nums.length-1];
        for (int j = nums.length-2; j >= 0; j--) {
            tmp[j] = tmp[j+1] * nums[j];
        }

        int mult = 1;
        for (int i = 0; i < nums.length-1; i++) {
            res[i] = mult * tmp[i+1];
            mult *= nums[i];
        }
        res[nums.length-1] = mult;
        return res;
    }
}
