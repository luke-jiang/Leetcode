// [DFS]

/** Given a list of words (without duplicates), please write a program that returns
  * all concatenated words in the given list of words.
  * A concatenated word is defined as a string that is comprised entirely of at least
  * two shorter words in the given array.
  *
  * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat",
  *         "ratcatdogcat"]
  *
  * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
  * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
  * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
  * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
  */

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String w : words) {
            set.add(w);
        }
        for (String w : words) {
            set.remove(w);
            if (dfs(set, w)) {
                res.add(w);
            }
            set.add(w);
        }
        return res;
    }

    private boolean dfs(Set<String> set, String word) {
        if (set.contains(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String w1 = word.substring(0, i);
            String w2 = word.substring(i);
            if (set.contains(w1) && dfs(set, w2)) {
                return true;
            }
        }
        return false;
    }
}
