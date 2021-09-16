class Solution {
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    private boolean isCapitalLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char p = s.charAt(i);
            char q = s.charAt(j);
            if (isCapitalLetter(p)) {
                p = (char) (p - 'A' + 'a');
            }
            if (isCapitalLetter(q)) {
                q = (char) (q - 'A' + 'a');
            }
            // System.out.println(p);
            // System.out.println(q);
            if (!isAlphaNumeric(p)) {
                i++; continue;
            }
            if (!isAlphaNumeric(q)) {
                j--; continue;
            }
            if (p != q) {
                // System.out.println(i);
                // System.out.println(j);
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
