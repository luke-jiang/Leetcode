class Solution {
    // modification based on binary search
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int low = 0;
        int high = nums.length-1;
        if (nums[low] == target) return true;
        // make sure nums[low] != nums[high]
        while (low < nums.length && nums[low] == nums[high]) low++;
        return search(nums, target, low, high);
    }

    private boolean search(int[] nums, int target, int low, int high) {
        if (low > high) return false;
        int mid = low + (high - low)/2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[low] <= nums[mid]) {
            // the sequence is increasing, normal binary search
            if (target >= nums[low] && target < nums[mid]) {
                return search(nums, target, low, mid-1);
            } else {
                return search(nums, target, mid+1, high);
            }
        } else {
            // hard part: the pivot is contained in the sequence
            if (target > nums[mid] && target <= nums[high]) {
                return search(nums, target, mid+1, high);
            } else {
                return search(nums, target, low, mid-1);
            }
        }
    }
}
