class Solution {
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
        }
        int max = 0, maxChar = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (freq[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx += 2;
            freq[maxChar]--;
        }
        // fill other characters starting at the end of the sequence of the maxChar
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        return String.valueOf(res);
    }
}
