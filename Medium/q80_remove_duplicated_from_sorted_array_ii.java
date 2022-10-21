class Solution {
    public int removeDuplicates(int[] nums) {
        int end = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[end-2] == nums[end-1] && nums[end-1] == nums[i]) {
                continue;
            } else {
                nums[end] = nums[i];
                end++;
            }
        }
        return end;
    }
}
