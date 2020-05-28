// [Set]

/** Given an unsorted array of integers, find the length of the longest consecutive
  * elements sequence.
  * Your algorithm should run in O(n) complexity.
  * Example:
  * [100, 4, 200, 1, 3, 2] -> 4 because [1,2,3,4]
  */

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) set.add(i);

        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int len = 0;
            for (int i = num; set.contains(i); i++) len++;
            res = Math.max(res, len);
        }

        return res;
    }
}
