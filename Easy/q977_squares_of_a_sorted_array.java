class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int next = 0;
        int nonneg = nums.length; // index of the first non-negative element
        for (int i = 0; i < len; i++) {
            if (nonneg == nums.length && nums[i] >= 0) {
                nonneg = i;
            }
        }
        int i = nonneg - 1;  // negative elements
        int j = nonneg;      // positive elements
        while (i >= 0 && j < len) {
            if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                res[next++] = nums[i] * nums[i]; i--;
            } else {
                res[next++] = nums[j] * nums[j]; j++;
            }
        }
        while (i >= 0) {
            res[next++] = nums[i] * nums[i]; i--;
        }
        while (j < len) {
            res[next++] = nums[j] * nums[j]; j++;
        }
        return res;
    }
}
