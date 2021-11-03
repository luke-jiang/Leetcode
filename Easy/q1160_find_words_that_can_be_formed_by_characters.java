class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] chars_freq = toFreq(chars);
        int res = 0;
        for (String w : words) {
            if (subset(toFreq(w), chars_freq)) res += w.length();
        }
        return res;
    }
    
    private int[] toFreq(String word) {
        int[] res = new int[26];
        for (int i = 0; i < word.length(); i++) {
            res[word.charAt(i) - 'a']++;
        }
        return res;
    }
    
    private boolean subset(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) return false;
        }
        return true;
    }
}
