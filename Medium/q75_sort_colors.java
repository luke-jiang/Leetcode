/** Given an array nums with n objects colored red, white, or blue, sort them in-place so that 
  * objects of the same color are adjacent, with the colors in the order red, white, and blue.
  *
  * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
  *
  * You must solve this problem without using the library's sort function.
  *
  * Example 1:
  * Input: nums = [2,0,2,1,1,0]
  * Output: [0,0,1,1,2,2]
 */

class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int n : nums) {
            nums[twos] = 2;
            twos++;
            if (n == 2) continue;
            nums[ones] = 1;
            ones++;
            if (n == 1) continue;
            nums[zeros] = 0;
            zeros++;
        }
    }
}
