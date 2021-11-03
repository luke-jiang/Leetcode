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
        } else if (nums[mid] > nums[to]) {
            return findMin(nums, mid, to);
        } else {
            // not sure which half the min can reside in
            // decreemnt `to` to reduce search space
            // invariant still holds: the region [form, to] hold the min
            return findMin(nums, from, to-1);
        }
    }
}
