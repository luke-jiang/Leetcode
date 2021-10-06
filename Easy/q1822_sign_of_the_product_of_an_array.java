class Solution {
    public int arraySign(int[] nums) {
        boolean positive = true;
        for (int n : nums) {
            if (n == 0) return 0;
            else if (n < 0) positive = !positive;
        }
        return positive ? 1 : -1;
    }
}
