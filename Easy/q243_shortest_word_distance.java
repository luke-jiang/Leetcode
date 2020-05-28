/** Given a list of words and two words word1 and word2, return the shortest
  * distance between these two words in the list.
  *
  * Example:
  * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
  * Input:  word1 = “coding”, word2 = “practice”
  * Output: 3
  * Input: word1 = "makes", word2 = "coding"
  * Outuput: 1
  */



class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int dist = words.length;
        int fst = -1;
        int snd = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                fst = i;
            } else if (words[i].equals(word2)) {
                snd = i;
            }
            if (fst != -1 && snd != -1) {
                dist = Math.min(dist, Math.abs(fst - snd));
            }
        }
        return dist;
    }
}
