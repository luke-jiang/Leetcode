class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        int len = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                len++;
            } else {
                sb.append(prev);
                if (len > 1) sb.append(len);
                prev = chars[i];
                len = 1;
            }
        }
        sb.append(prev);
        if (len > 1) sb.append(len);
        
        len = sb.length();
        for (int i = 0; i < len; i++) {
            chars[i] = sb.charAt(i);
        }
        return len;
    }
}
