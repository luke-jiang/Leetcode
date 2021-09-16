// [Bitwise]
/** Given an array of numbers nums, in which exactly two elements appear only
  * once and all the other elements appear exactly twice. Find the two elements
  * that appear only once.
  *
  * Example:
  * input: [1,2,1,3,2,5]
  * Output: [3,5]
  *
  * Note:
  * The order of the result is not important.
  * Your algorithm should run in linear runtime complexity.
  * Could you implement it using only constant space complexity?
  */

class Solution {
    // naive solution: use set
    public int[] singleNumber(int[] nums) {
       Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (set.contains(val)) {
                set.remove(val);
            } else {
                set.add(val);
            }
        }

        int[] res = new int[2];
        int i = 0;
        for (int x : set) {
            res[i] = x;
            i++;
        }
        return res;
    }
}

class Solution {
    // use property of xor: x ^ a ^ a = x
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        // xor = x ^ y, where x, y are the value to be returned.
        // find the first 1 bit of int xor, which is the first bit
        // that x is different from y
        int bitmask = 1;
        for (int i = xor; i % 2 == 0; i /= 2) {
            bitmask = bitmask * 2;
        }
        // use bitmask to separate numbers into two groups:
        // A = {ai, ai, ..., x}
        // B = {aj, aj, ..., y}
        // then, use xor property again for both A and B.
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bitmask) == 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        return new int[] {x, y};
    }
}
