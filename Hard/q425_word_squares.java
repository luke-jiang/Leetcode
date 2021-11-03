// [Trie, Backtracking]

class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
        public List<String> getWords(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) return new ArrayList<>();
                curr = curr.children[c - 'a'];
            }
            return dfs(curr, new ArrayList<>());
        }
        private List<String> dfs(TrieNode curr, List<String> res) {
            if (curr == null) return res;
            if (curr.word != null) {
                res.add(curr.word);
            }
            for (TrieNode child : curr.children) {
                res = dfs(child, res);
            }
            return res;
        }
    }
    
    Trie t;
    List<List<String>> res;
    int len;
    public List<List<String>> wordSquares(String[] words) {
        t = new Trie();
        for (String w : words) t.insert(w);
        res = new ArrayList<>();
        len = words[0].length();
        List<String> curr = new ArrayList<>();
        for (String w : words) {
            curr.add(w);
            backtrack(curr);
            curr.remove(0);
        }
        return res;
    }
    
    private void backtrack(List<String> curr) {
        if (curr.size() == len) {
            res.add(new ArrayList<>(curr));
        } else {
            StringBuilder p = new StringBuilder();
            for (int i = 0; i < curr.size(); i++) {
                p.append(curr.get(i).charAt(curr.size()));
            }
            for (String w : t.getWords(p.toString())) {
                curr.add(w);
                backtrack(curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
