class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int n : nums) {
            nums[twos] = 2;
            twos++;
            if (n == 2) continue;
            nums[ones] = 1;
            ones++;
            if (n == 1) continue;
            nums[zeros] = 0;
            zeros++;
        }
    }
}
