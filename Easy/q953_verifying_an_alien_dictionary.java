
/** In an alien language, surprisingly they also use english lowercase letters,
  * but possibly in a different order. The order of the alphabet is some permutation
  * of lowercase letters.
  * Given a sequence of words written in the alien language, and the order of the alphabet,
  * return true if and only if the given words are sorted lexicographicaly in this
  * alien language.
  *
  * Example1:
  * words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
  * return true, because 'h' comes before 'l'
  *
  * Example2:
  * words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
  * return false, becayse 'd' comes after 'l'
  *
  * Example3:
  * words = words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
  * return false, The first three characters "app" match, and the second string is
  * shorter (in size.) According to lexicographical rules "apple" > "app", because
  * 'l' > '∅', where '∅' is defined as the blank character which is less than any
  * other character (More info).
  */

class Solution {
      public boolean isAlienSorted(String[] words, String order) {
          int[] chars = new int[26];
          for (int i = 0; i < order.length(); i++) {
              chars[order.charAt(i) - 'a'] = i;
          }

          for (int i = 0; i < words.length-1; i++) {
              String word1 = words[i];
              String word2 = words[i+1];

              int j = 0;
              int end = Math.min(word1.length(), word2.length());
              while (j < end && word1.charAt(j) == word2.charAt(j)) j++;
              if (j < word1.length() && j >= word2.length()) return false;
              if (j >= word1.length()) continue;
              int order1 = chars[word1.charAt(j) - 'a'];
              int order2 = chars[word2.charAt(j) - 'a'];
              if (order1 > order2) return false;
          }
          return true;
      }
}
