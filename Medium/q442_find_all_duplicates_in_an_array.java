// Special Array Condition

/** Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear
  * twice and others appear once.
  * Find all the elements that appear twice in this array.
  * Could you do it without extra space and in O(n) runtime?
  *
  * Example:
  * input: [4,3,2,7,8,2,3,1]
  * output: [2,3]
  */

class Solution {
    // since 1 <= a[i] <= n, we can treat nums[i] as a valid index of the array.
    // All values in nums are positive, so we can mark nums[nums[i]] as negative
    // when traversed at i. Ifnums[nums[i]] is already negative, then a duplicate
    // is found.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if (nums[index] < 0) res.add(Math.abs(nums[i]));
            else nums[index] = -nums[index];
        }

        return res;
    }
}
