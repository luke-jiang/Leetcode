class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
