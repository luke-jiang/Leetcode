// [Trie]
/** Design a data structure that supports the following two operations:
  *     void addWord(word)
  *     bool search(word)
  * search(word) can search a literal word or a regular expression string containing
  * only letters a-z or .. A . means it can represent any one letter.
  *
  * Example:

    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad") -> false
    search("bad") -> true
    search(".ad") -> true
    search("b..") -> true

  * Note:
  * You may assume that all words are consist of lowercase letters a-z.
  */

class WordDictionary {
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
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode node, String word) {
        if (node == null) return false;
        if (word.length() == 0) {
            return node.isEnd;
        } else {
            char next = word.charAt(0);
            if (next == '.') {
                for (TrieNode n : node.children) {
                    if (n != null && search(n, word.substring(1, word.length()))) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = next - 'a';
                return search(node.children[index], word.substring(1, word.length()));
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
