class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        boolean reverse = true;
        int len = s.length();
        for (int i = 0; i < len; i+=k) {
            String sub = s.substring(i, Math.min(i+k, len));
            if (reverse) {
                StringBuilder sb1 = new StringBuilder(sub);
                sb1.reverse();
                sb.append(sb1.toString());
            } else {
                sb.append(sub);
            }
            reverse = !reverse;
        }
        return sb.toString();
    }
}
