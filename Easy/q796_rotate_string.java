class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == goal.charAt(0) && (s.substring(i) + s.substring(0, i)).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
