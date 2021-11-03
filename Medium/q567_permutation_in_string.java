class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (set.contains(c)) {
                // System.out.println(i);
                int end = Math.min(s2.length(), i + s1.length());
                String p = s2.substring(i, end);
                // System.out.println(p);
                if (checkFreq(s1, p)) return true;
            }
        }
        return false;
    }
    
    private boolean checkFreq(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']--;
            freq[s2.charAt(i) - 'a']++;
        }
        for (int n : freq) if (n != 0) return false;
        return true;
    }
}
