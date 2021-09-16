// [HashMap]

/** Given an array of integers, return indices of the two numbers such that they
  * add up to a specific target.
  *
  * You may assume that each input would have exactly one solution, and you may
  * not use the same element twice.
  *
  * Example:
  * Given nums = [2, 7, 11, 15], target = 9,
  * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
  */

class Solution {
   // brute-force. runtime: O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}

class Solution {
  // use a HashMap to cache traversed <integer, index> pair
  // check if complement of the interger exists in the map
  public int[] twoSum(int[] nums, int target) {
      int[] res = new int[2];
      int len = nums.length;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < len; i++) {
          int complement = target - nums[i];
          if (map.containsKey(complement)) {
              res[0] = map.get(complement);
              res[1] = i;
          }
          map.put(nums[i], i);
      }
      return res;
  }
}
