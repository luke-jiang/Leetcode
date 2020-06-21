// [HashMap]

/** Design a class which receives a list of words in the constructor, and implements
  * a method that takes two words word1 and word2 and return the shortest distance
  * between these two words in the list. Your method will be called repeatedly many
  * times with different parameters.
  *
  * Example:
  * words = ["practice", "makes", "perfect", "coding", "makes"]
  * input: word1 = "coding", word2 = "practice"
  * output: 3
  * input: word1 = "makes", word2 = "coding"
  * output: 1
  *
  * Note:
  * You may assume that word1 does not equal to word2, and word1 and word2 are
  * both in the list.
  */

class WordDistance {
    // map of string and their indices in words
    Map<String, List<Integer>> map;

    // initialize
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(words[i], ls);
            }
        }
    }

    // this method will be called multiple times.
    public int shortest(String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        List<Integer> ls1 = map.get(word1);
        List<Integer> ls2 = map.get(word2);
        int i1 = 0;
        int i2 = 0;
        // traverse two lists to find the shortest distance
        while (i1 < ls1.size() && i2 < ls2.size()) {
            int v1 = ls1.get(i1);
            int v2 = ls2.get(i2);
            if (v1 < v2) {
                dist = Math.min(dist, v2 - v1);
                i1++;
            } else {
                dist = Math.min(dist, v1 - v2);
                i2++;
            }
        }

        return dist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
