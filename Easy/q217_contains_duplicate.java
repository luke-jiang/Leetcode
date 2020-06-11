/** Given an array of integers, find if the array contains any duplicates.
  * Your function should return true if any value appears at least twice in the array,
  * and it should return false if every element is distinct.
  *
  * Example1:
  * [1,2,3,1] -> true
  * [1,2,3,4] -> false
  * [1,1,1,3,3,4,3,2,4,2] -> true
  */

class Solution1 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        return set.size() != nums.length;
    }
}

class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
