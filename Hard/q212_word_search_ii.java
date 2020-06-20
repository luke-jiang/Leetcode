// [Trie, DFS]

/** Given a 2D board and a list of words from the dictionary, find all words in the board.
  * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
  * cells are those horizontally or vertically neighboring. The same letter cell may not be
  * used more than once in a word.
  *
  * Example:
  * Input:
    board = [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    words = ["oath","pea","eat","rain"]
  * Output: ["eat","oath"]
  *
  * Note:
  * All inputs are consist of lowercase letters a-z.
  *The values of words are distinct.
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

        public Trie(String[] words) {
            root = new TrieNode();
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
    }

    List<String> res;
    int x;
    int y;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        Trie trie = new Trie(words);

        x = board.length;
        y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dfs(board, i, j, trie.root);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= x || j < 0 || j >= y) return;
        char c = board[i][j];
        if (c == '-') return;
        TrieNode next = node.children[c - 'a'];
        if (next == null) return;

        if (next.isEnd && next.val != null) {
            res.add(next.val);
            next.val = null;
        }

        board[i][j] = '-';

        dfs(board, i - 1, j ,next);
        dfs(board, i, j - 1, next);
        dfs(board, i + 1, j, next);
        dfs(board, i, j + 1, next);

        board[i][j] = c;
    }
}
