class Solution {
    public int maxRotateFunction(int[] nums) {
        int F = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            F += i * nums[i];
            sum += nums[i];
        }
        int max = F;
        for (int i = nums.length-1; i >= 0; i--) {
            F += sum - nums[i] * nums.length;
            max = Math.max(max, F);
        }
        return max;
    }
}
