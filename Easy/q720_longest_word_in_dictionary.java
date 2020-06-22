// [Trie]

/** Given a list of strings words representing an English Dictionary, find the longest word in
  * words that can be built one character at a time by other words in words. If there is more
  * than one possible answer, return the longest word with the smallest lexicographical order.
  * If there is no answer, return the empty string.
  *
  * Example 1:
  * Input:
  * words = ["w","wo","wor","worl", "world"]
  * Output: "world"
  * Explanation:
  * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
  *
  * Example 2:
  * Input:
  * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
  * Output: "apple"
  * Explanation:
  * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is
  * lexicographically smaller than "apply".
  *
  * Note:
  * All the strings in the input will only contain lowercase letters.
  * The length of words will be in the range [1, 1000].
  * The length of words[i] will be in the range [1, 30].
  */

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String val;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;
        List<String> ans;

        public Trie(String[] words) {
            root = new TrieNode();
            ans = new ArrayList<>();
            for (String word : words) {
                insert(word);
            }
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.val = word;
            curr.isEnd = true;
        }

        public void search(TrieNode node) {
            boolean isLeaf = true;
            for (TrieNode child : node.children) {
                if (child != null && child.isEnd) {
                    search(child);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                ans.add(node.val);
            }
        }
    }

    private class NumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        for (TrieNode child : trie.root.children) {
            if (child != null && child.isEnd) {
                trie.search(child);
            }
        }

        Collections.sort(trie.ans, new NumComparator());

        if (trie.ans.size() > 0) {
            return trie.ans.get(0);
        }
        return "";
    }
}
