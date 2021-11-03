class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int gcd = 1;
        for (int i = 1; i <= Math.min(len1, len2); i++) {
            if (len1 % i == 0 && len2 % i == 0) gcd = i;
        }
        // System.out.println(gcd);
        String candidate = str1.substring(0, gcd);
        // System.out.println(candidate);
        for (int i = 0; i < len1; i+=gcd) {
            if (!str1.substring(i, i+gcd).equals(candidate)) return "";
        }
        for (int i = 0; i < len2; i+=gcd) {
            if (!str2.substring(i, i+gcd).equals(candidate)) return "";
        }
        return candidate;
    }
}
