// [Boyer-Moore]

/** Given an array nums of size n, return the majority element.
  * The majority element is the element that appears more than ⌊n / 2⌋ times. 
  * You may assume that the majority element always exists in the array.
  */

// INTUITION:
// If the majority element can "cancel out" other elements, then the overall remaining
// element is still the majority element.
// Maintain a suffix suff where suff[0] is the majority element in that suffix.

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
