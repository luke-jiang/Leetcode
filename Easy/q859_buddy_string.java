class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int len = s.length();
        int[] freq = new int[26];
        
        int[] fst = new int[2];
        int[] snd = new int[2];
        Arrays.fill(fst, -1);
        Arrays.fill(snd, -1);
        boolean eqSwap = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char g = goal.charAt(i);
            if (c == g && freq[c - 'a'] > 0) {
                eqSwap = true;
            } else if (c == g) {
                freq[c - 'a']++;
                continue;
            } else if (fst[0] == -1) {
                fst[0] = c;
                fst[1] = g;
            } else if (snd[0] == -1) {
                snd[0] = g;
                snd[1] = c;
            } else {
                return false;
            }
        }
        if (fst[0] == -1 && snd[0] == -1) {
            return eqSwap;
        } else {
            return fst[0] == snd[0] && fst[1] == snd[1];
        }
    }
}
