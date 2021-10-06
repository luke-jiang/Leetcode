class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = s.charAt(0) - '0';
        int len = 1;
        int prevlen = 0;
        
        for (int i = 1; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (prev == n) {
                len++;
            } else {
                res += Math.min(prevlen, len);
                prev = n;
                prevlen = len;
                len = 1;
            }
        }
        res += Math.min(prevlen, len);
        
        return res;
    }
}
