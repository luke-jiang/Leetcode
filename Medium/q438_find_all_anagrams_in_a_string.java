// [SlidingWindow, Two-Pointers, Pre-Cache]

/** Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
  * Strings consists of lowercase English letters only and the length of both
  * strings s and p will not be larger than 20,100.
  * The order of output does not matter.
  *
  * Examples:
  * s = "cbaebabacd", p = "abc" -> [0,6]
  * s = "abab", p = "ab" -> [0,1,2]
  */

class Solution1 {
    // more concise solution than the 2-pointers solution.
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (slen < plen) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < slen; i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= plen) {
                sCount[s.charAt(i-plen) - 'a']--;
            }
            if (Arrays.equals(pCount, sCount)) {
                res.add(i-plen+1);
            }
        }

        return res;
    }
}

class Solution2 {
    // pre-process string p into an array of size 26, representing characters
    // 'a' to 'z'. Each entry contains number of occurences of the corresponding
    // character in string p.
    // Use two pointers to denote current substring.
    // Also keep another array "running", which is a reservior of possible chaaracters
    // to match at current state of matching.
    // While matching, use "size" to keep track of how many characters are still
    // to be matched. If size == 0, then we found an anagram.
    int[] chars;
    int[] running;
    int len = 26;

    public List<Integer> findAnagrams(String s, String p) {
        // initialize chars and runnings.
        chars = new int[len];
        running = new int[len];
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            chars[index]++;
            running[index]++;
        }

        List<Integer> res = new ArrayList<>();

        // initialize size to be number of characters in p.
        int size = p.length();

        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < s.length()) {
            int c = s.charAt(p2) - 'a';
            if (chars[c] == 0) {
                // character not in p, no possible matching.
                // goto the next character and re-initialize running
                // and size.
                p1 = p2 + 1;
                p2 = p1;
                for (int i = 0; i < len; i++) running[i] = chars[i];
                size = p.length();
            } else if (running[c] > 0) {
                // update running to match the current character
                running[c]--;
                size--;
                if (size == 0) {
                    // found a match, move the sliding window to right by 1.
                    // update size and running accordingly.
                    res.add(p1);
                    running[s.charAt(p1) - 'a']++;
                    p1++;
                    p2++;
                    size++;
                } else {
                    // consider the next character.
                    p2++;
                }
            } else {
                // the current substring cannot be a match, because it contains
                // more current character than p.
                // prev points to the previous occurence of the current character.
                // discard substring s[p1, prev], update running and size accordingly.
                int prev = p2 - 1;
                while (prev >= p1 && s.charAt(prev) != s.charAt(p2)) prev--;
                for (int i = p1; i < prev; i++) {
                    running[s.charAt(p1) - 'a']++;
                    size++;
                }
                // From now, consider only substring starting from prev + 1.
                p1 = prev + 1;
                p2++;
            }
        }

        return res;
    }
}
