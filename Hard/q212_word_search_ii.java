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
        String word;
        TrieNode[] children;
        public TrieNode() {
            word = null;
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) insert(word);
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
            curr.word = word;
        }
    }

    int m;
    int n;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie(words);
        m = board.length;
        n = board[n].length;
        res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, t.root);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        char c = board[i][j];
        if (c == '-') return;
        TrieNode next = node.children[c - 'a'];
        if (next == null) return;

        if (next.word != null) {
            res.add(next.word);
            next.word = null; // each word only appear in res once
        }

        board[i][j] = '-';

        dfs(board, i - 1, j ,next);
        dfs(board, i + 1, j, next);
        dfs(board, i, j - 1, next);
        dfs(board, i, j + 1, next);

        board[i][j] = c;
    }
}
