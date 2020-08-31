// [Backtracking]

/** Given an array of strings arr. String s is a concatenation of a sub-sequence of arr
  * which have unique characters.
  *
  * Return the maximum possible length of s.
  *
  * Example 1:
  * Input: arr = ["un","iq","ue"]
  * Output: 4
  * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
  * Maximum length is 4.
  *
  * Example 2:
  * Input: arr = ["cha","r","act","ers"]
  * Output: 6
  * Explanation: Possible solutions are "chaers" and "acters".
  *
  * Example 3:
  * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
  * Output: 26
  *
  * Constraints:
  * 1 <= arr.length <= 16
  * 1 <= arr[i].length <= 26
  * arr[i] contains only lower case English letters.
  */

class Solution {
    int max = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);
        return max;
    }

    private void backtrack(List<String> arr, String path, int index) {
        if (index >= arr.size()) {
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            String newpath = path + arr.get(i);
            if (unique(newpath)) {
                max = Math.max(max, newpath.length());
                backtrack(arr, newpath, i+1);
            }
        }
    }

    private boolean unique(String path) {
        int[] freq = new int[26];
        for (char c : path.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1) return false;
        }
        return true;
    }
}
