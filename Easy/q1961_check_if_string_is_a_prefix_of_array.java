class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() < s.length() && i < words.length) {
            sb.append(words[i]);
            i++;
        }
        if (sb.length() != s.length() || i > words.length) {
            return false;
        }
        return s.equals(sb.toString());
    }
}
