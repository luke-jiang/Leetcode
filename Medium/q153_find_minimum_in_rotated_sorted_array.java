// [BinarySearch]

/** Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
  * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
  * Find the minimum element.
  * You may assume no duplicate exists in the array.
  *
  * Example 1:
  * Input: [3,4,5,1,2]
  * Output: 1
  *
  * Example 2:
  * Input: [4,5,6,7,0,1,2]
  * Output: 0
  */

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int from, int to) {
        if (from == to || from + 1 == to) {
            return Math.min(nums[from], nums[to]);
        }
        int mid = from + (to - from) / 2;
        if (nums[mid] < nums[to]) {
            return findMin(nums, from, mid);
        } else  {
            return findMin(nums, mid, to);
        }
    }
}
