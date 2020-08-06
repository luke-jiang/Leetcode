/** Implement next permutation, which rearranges numbers into the lexicographically
  * next greater permutation of numbers.
  * If such arrangement is not possible, it must rearrange it as the lowest possible
  * order (ie, sorted in ascending order).
  * The replacement must be in-place and use only constant extra memory.
  * Here are some examples. Inputs are in the left-hand column and its corresponding
  * outputs are in the right-hand column.

    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

  */

  class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i-1 >= 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        if (i-1 >= 0) {
            int x = nums[i-1];
            int j = i;
            while (j+1 < nums.length && nums[j+1] > x) j++;
            nums[i-1] = nums[j];
            nums[j] = x;
        }

        int k = nums.length - 1;
        while (i < k) {
            int tmp = nums[k];
            nums[k] = nums[i];
            nums[i] = tmp;
            i++;
            k--;
        }
    }
}
