class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                if (x.length() != y.length()) {
                    return y.length() - x.length();
                } else {
                    int len = x.length();
                    int i = 0;
                    while (i < len && x.charAt(i) == y.charAt(i)) i++;
                    if (i == len) return 0;
                    else return y.charAt(i) - x.charAt(i);
                }
            }
        });
        return nums[k-1];
    }
}
