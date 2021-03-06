class Solution1 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        int[] nums1 = new int[len];
        for (int i = 0; i < len; i++) {
            nums1[i] = nums[(i+len-k) % len];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = nums1[i];
        }
    }
}

class Solution2 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int from, int to) {
        for (int i = from, j = to; i < j; i++, j--) {
            // System.out.println(i);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
