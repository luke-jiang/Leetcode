class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (isPeak(nums, 0)) {
            return 0;
        } else if (isPeak(nums, nums.length - 1)) {
            return nums.length - 1;
        } else {
            return search(nums, 0, nums.length - 1);
        }
    }
    
    private int search(int[] nums, int low, int high) {
        // System.out.println(low + "," + high);
        if (low >= high - 1) return -1;
        int mid = low + (high - low) / 2;
        if (isPeak(nums, mid)) {
            return mid;
        } 
        int left = search(nums, low, mid);
        if (left != -1) return left;
        return search(nums, mid, high);
    }
    
    private boolean isPeak(int[] nums, int i) {
        if (i == 0) {
            return nums[i] > nums[i+1];
        } else if (i == nums.length - 1) {
            return nums[i] > nums[i-1];
        } else {
            return nums[i] > nums[i+1] && nums[i] > nums[i-1];
        }
    }
}
