class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] tmp = new int[len];
        int min = (len-1)/2;
        int max = len-1;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                tmp[i] = nums[min--];
            } else {
                tmp[i] = nums[max--];
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }
}
