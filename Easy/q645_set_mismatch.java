// [Bit Manipulation]

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] ans = {0, 0};
        for (int i = 0; i < n; i++) {
            ans[1] ^= (i+1) ^ nums[i];
            count[nums[i]-1]++;
            if (count[nums[i]-1] == 2) {
                ans[0] = nums[i];
            }
        }
        ans[1] ^= ans[0];
        return ans;
    }
}
