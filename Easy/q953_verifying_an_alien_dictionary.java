
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

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            dict[c - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!lessThan(dict, words[i], words[i+1])) return false;
        }
        return true;
    }
    
    private boolean lessThan(int[] dict, String a, String b) {
        int i = 0;
        while (i < Math.min(a.length(), b.length())) {
            char ai = a.charAt(i);
            char bi = b.charAt(i);
            // System.out.println(dict[ai - 'a'] + "," + dict[bi - 'a']);
            if (dict[ai - 'a'] < dict[bi - 'a']) {
                return true;
            } else if (dict[ai - 'a'] > dict[bi - 'a']) {
                return false;
            }
            i++;
        }
        return i == a.length();
    }
}
