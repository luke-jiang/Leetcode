class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        Set<Integer> s = new HashSet<>(len);
        for (String str : nums) {
            s.add(Integer.parseInt(str, 2));
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!s.contains(i)) {
                return toStr(i, len);
            }
        }
        return "";
    }

    private String toStr(int n, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }
}
