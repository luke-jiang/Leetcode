class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        int sum = 0;
        for (int i = len-1; i >= 0; i--) {
            sum += nums[i];
            sums[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < len; i++) {
            int right = (i < len-1) ? sums[i+1] : 0;
            if (right == sum) return i;
            sum += nums[i];
        }
        return -1;
    }
}
