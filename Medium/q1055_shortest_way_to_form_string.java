class Solution {
    public int shortestWay(String source, String target) {
        int res = 0;
        int t = 0;
        while (t < target.length()) {
            int pt = t;
            for (int s = 0; s < source.length(); s++) {
                if (t <= target.length() && source.charAt(s) == target.charAt(t)) {
                    t++;
                }
            }
            if (pt != t) {
                res += 1;
            } else {
                return -1;
            }
        }
        return res;
    }
}
