class Solution {
    public void moveZeroes(int[] nums) {
        int tail = 0;  // tail of nonzero values
        int head = 0;
        while (head < nums.length) {
            if (nums[head] == 0) {
                head++;
            } else {
                swap(nums, tail, head);
                tail++;
                head++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
