// [Trie]

class Solution {
    class TrieNode {
        String val;
        TrieNode[] children;
        public TrieNode() {
            val = null;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
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
    }
    
    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        for (String s : strs) {
            if (s.length() == 0) return "";
            insert(s);
        }
        
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        int u = getUniqueChild(curr);
        while (u != -1 && curr.val == null) {
            sb.append((char) (u + 'a'));
            curr = curr.children[u];
            u = getUniqueChild(curr);
        }
        
        return sb.toString();
    }
    
    private int getUniqueChild(TrieNode node) {
        if (node == null) return -1;
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && res == -1) {
                res = i;
            } else if (node.children[i] != null) {
                return -1;
            }
        }
        return res;
    }
}
