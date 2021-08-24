// [BFS, String search, HashMap]

/** Given two words (beginWord and endWord), and a dictionary's word list, find the
  * length of shortest transformation sequence from beginWord to endWord, such that:
  *     Only one letter can be changed at a time.
  *     Each transformed word must exist in the word list.
  *
  * Note:
  * Return 0 if there is no such transformation sequence.
  * All words have the same length.
  * All words contain only lowercase alphabetic characters.
  * You may assume no duplicates in the word list.
  * You may assume beginWord and endWord are non-empty and are not the same.
  */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        // maps a pattern to a list of real words
        Map<String, List<String>> dict = new HashMap<>();
        // build the dictionary
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                if (!dict.containsKey(newWord)) {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    dict.put(newWord, words);
                } else {
                    dict.get(newWord).add(word);
                }
            }
        }

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        // BFS
        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                // try out each patterns
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                for (String adj : dict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adj.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adj)) {
                        visited.put(adj, true);
                        q.add(new Pair(adj, level+1));
                    }
                }
            }
        }

        return 0;
    }
}
