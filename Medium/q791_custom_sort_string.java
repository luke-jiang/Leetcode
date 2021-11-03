class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] searched = new boolean[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            int index = c - 'a';
            searched[index] = true;
            while (freq[index] > 0) {
                sb.append(c);
                freq[index]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && !searched[i]) {
                for (int j = 0; j < freq[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
        
    }
}
