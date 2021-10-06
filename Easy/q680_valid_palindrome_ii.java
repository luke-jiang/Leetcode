class Solution {
    public boolean validPalindrome(String s) {
        return search(s, 0, s.length()-1, true);
    }
    
    private boolean search(String s, int i, int j, boolean canSkip) {
        if (i > j) {
            return true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return search(s, i+1, j-1, canSkip);
        } else if (!canSkip) {
            return false;
        } else {
            return search(s, i+1, j, false) || search(s, i, j-1, false);
        }
    }
}
