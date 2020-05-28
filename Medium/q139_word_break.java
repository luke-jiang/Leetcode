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
