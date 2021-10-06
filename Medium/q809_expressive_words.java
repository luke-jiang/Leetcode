/** Sometimes people repeat letters to represent extra feeling. For example:
  * "hello" -> "heeellooo"
  * "hi" -> "hiiii"
  * In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
  * You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal
  * to s by any number of applications of the following extension operation: choose a group consisting of characters c,
  * and add some number of characters c to the group so that the size of the group is three or more.
  *
  * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo"
  * since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".
  * If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
  * Return the number of query strings that are stretchy.
  *
  * Example 1:
  * Input: s = "heeellooo", words = ["hello", "hi", "helo"]
  * Output: 1
  * Explanation:
  * We can extend "e" and "o" in the word "hello" to get "heeellooo".
  * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
  *
  * Example 2:
  * Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
  * Output: 3
  */


class Solution {

    public int expressiveWords(String s, String[] words) {
        String s_ = compress(s);
        int res = 0;

        for (String w : words) {
            String w_ = compress(w);
            if (match(s_, w_)) {
                res++;
            }
        }
        return res;
    }

    private String compress(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        char len = 1;
        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            if (prev == next) {
                len++;
            } else {
                sb.append(prev);
                sb.append((char) ('0' + len));
                prev = next;
                len = 1;
            }
        }
        sb.append(prev);
        sb.append((char) ('0' + len));
        return sb.toString();
    }

    private boolean match(String p, String s) {
        if (s.length() != p.length()) return false;
        for (int i = 0; i < s.length(); i+=2) {
            char pc = p.charAt(i);
            char pl = p.charAt(i+1);
            char sc = s.charAt(i);
            char sl = s.charAt(i+1);
            if (pc != sc) return false;
            else if (pl < '3' && pl != sl) return false;
            else if (pl < sl) return false;
        }
        return true;
    }
}
