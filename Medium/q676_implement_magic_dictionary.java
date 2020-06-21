// [Trie]

/** Implement a magic directory with buildDict, and search methods.
  * For the method buildDict, you'll be given a list of non-repetitive words to build
  * a dictionary.
  * For the method search, you'll be given a word, and judge whether if you modify exactly
  * one character into another character in this word, the modified word is in the dictionary
  * you just built.
  *
  * Example 1:
  * Input: buildDict(["hello", "leetcode"]), Output: Null
  * Input: search("hello"), Output: False
  * Input: search("hhllo"), Output: True
  * Input: search("hell"), Output: False
  * Input: search("leetcoded"), Output: False
  *
  * Note:
  * You may assume that all the inputs are consist of lowercase letters a-z.
  * For contest purpose, the test data is rather small by now. You could think about highly
  *   efficient algorithm after the contest.
  * Please remember to RESET your class variables declared in class MagicDictionary, as
  *   static/class variables are persisted across multiple test cases. Please see here for
  *   more details.
  */

class MagicDictionary {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            insert(word);
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        // replace each character with '.', which represent a wild card.
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char c = w[i];
            w[i] = '.';
            if (helper(w, 0, root, c - 'a')) return true;
            w[i] = c;
        }
        return false;
    }

    // dot is the currently replaced character
    private boolean helper(char[] word, int start, TrieNode node, int dot) {
        if (node == null) return false;
        if (start == word.length) {
            return node.isEnd;
        }

        char c = word[start];
        if (c != '.') {
            int index = c - 'a';
            TrieNode next = node.children[index];
            return next != null && helper(word, start+1, next, dot);
        } else {
            for (int i = 0; i < 26; i++) {
                if (i == dot) {
                    // ignore the case where dot matches back to the character
                    // it replaced.
                    continue;
                }
                TrieNode child = node.children[i];
                if (child != null && helper(word, start+1, child, dot)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
