class Solution {
    public String reverseWords(String s) {
        String[] splited = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = splited.length - 1; i >= 0; i--) {
            sb.append(splited[i]);
            if (i > 0) sb.append(' ');
        }
        return sb.toString();
    }
}
