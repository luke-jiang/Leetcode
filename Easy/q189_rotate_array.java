
/** Given an array, rotate the array to the right by k steps, where k is non-negative.
  *
  * Example 1:
  * Input: nums = [1,2,3,4,5,6,7], k = 3
  * Output: [5,6,7,1,2,3,4]
  * Explanation:
  * rotate 1 steps to the right: [7,1,2,3,4,5,6]
  * rotate 2 steps to the right: [6,7,1,2,3,4,5]
  * rotate 3 steps to the right: [5,6,7,1,2,3,4]
  *
  * Follow up:
  * Try to come up as many solutions as you can, there are at least 3 different ways to
  * solve this problem.
  * Could you do it in-place with O(1) extra space?
  */

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        int[] nums1 = new int[len];
        for (int i = 0; i < len; i++) {
            nums1[i] = nums[(i+len-k) % len];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = nums1[i];
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int from, int to) {
        for (int i = from, j = to; i < j; i++, j--) {
            // System.out.println(i);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
