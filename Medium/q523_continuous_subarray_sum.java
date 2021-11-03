class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // remainder -> index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rmd = sum % k;
            if (!map.containsKey(rmd)) map.put(rmd, i);
            else if (i - map.get(rmd) > 1) return true;
        }
        return false;
    }
}
