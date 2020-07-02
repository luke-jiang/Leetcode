/** Write a function that takes a string as input and reverse only the vowels of a string.
  * Example 1:
  * Input: "hello"
  * Output: "holle"
  *
  * Example 2:
  * Input: "leetcode"
  * Output: "leotcede"
  *
  * Note:
  * The vowels does not include the letter "y".
  */

class Solution {
    public String reverseVowels(String s) {
        char[] vowels = new char[s.length()];
        char[] word = s.toCharArray();
        int len = 0;
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            if (isVowel(c)) {
                vowels[len] = c;
                len++;
            }
        }
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            if (isVowel(c)) {
                len--;
                word[i] = vowels[len];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : word) {
            sb.append(c);
        }
        return sb.toString();

    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
