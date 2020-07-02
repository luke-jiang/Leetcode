/** Given a pattern and a string str, find if str follows the same pattern.
  * Here follow means a full match, such that there is a bijection between a letter
  * in pattern and a non-empty word in str.
  *
  * Example 1:
  * Input: pattern = "abba", str = "dog cat cat dog"
  * Output: true
  *
  * Example 2:
  * Input:pattern = "abba", str = "dog cat cat fish"
  * Output: false
  *
  * Example 3:
` * Input: pattern = "aaaa", str = "dog cat cat dog"
  * Output: false
  *
  * Example 4:
  * Input: pattern = "abba", str = "dog dog dog dog"
  * Output: false
  *
  * Notes:
  * You may assume pattern contains only lowercase letters, and str contains lowercase
  * letters that may be separated by a single space.
  */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            char p = pattern.charAt(i);
            String w = words[i];
            if (!map.containsKey(p)) {
                if (!set.contains(w)){
                    map.put(p, w);
                    set.add(w);
                } else {
                    return false;
                }

            } else if (!map.get(p).equals(w)) {
                return false;
            }
        }
        return true;
    }
}
