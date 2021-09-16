// [DP]

/** Given a non-empty string s and a dictionary wordDict containing a list of
  * non-empty words, determine if s can be segmented into a space-separated
  * sequence of one or more dictionary words.
  *
  * Note:
  * The same word in the dictionary may be reused multiple times in the segmentation.
  * You may assume the dictionary does not contain duplicate words.
  *
  * Examples:
  * "leetcode", ["leet", "code"] returns true
  * "applepenapple", ["apple", "pen"] returns true
  * "catsandog", ["cats", "dog", "sand", "and", "cat"] returns false
  */

class Solution {
    // opt[i] := true if the substring s[0, i] is breakable
    // opt[i] := OR { forall 0 <= j < i, opt[j] AND isWord(s[j+1, i]) }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;

        for (int i = 1; i < s.length()+1; i++) {
            boolean res = false;
            for (int j = 1; j <= i; j++) {
                if (opt[j-1] && wordDict.contains(s.substring(j-1, i))) {
                    res = true;
                }
            }
            opt[i] = res;
        }
        return opt[s.length()];
    }
}

class Solution {
    // slightly optimized version:
    // use set instead of list for checking if a substring is a valid word.
    // eager return when found one valid way of splitting.
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] opt = new boolean[s.length()+1];
        Set<String> dict = new HashSet<>(wordDict);
        opt[0] = true;
        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (opt[j-1] && dict.contains(s.substring(j-1, i))) {
                    opt[i] = true;
                    break;
                }
            }
        }
        return opt[s.length()];
    }
}

// use opt[len+1] and store default cases at opt[0]
