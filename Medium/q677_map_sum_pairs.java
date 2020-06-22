// [Trie]

/** Implement a MapSum class with insert, and sum methods.
  * For the method insert, you'll be given a pair of (string, integer). The string represents
  * the key and the integer represents the value. If the key already existed, then the original
  * key-value pair will be overridden to the new one.
  *
  * For the method sum, you'll be given a string representing the prefix, and you need to return
  * the sum of all the pairs' value whose key starts with the prefix.
  *
  * Example 1:
  * Input: insert("apple", 3), Output: Null
  * Input: sum("ap"), Output: 3
  * Input: insert("app", 2), Output: Null
  * Input: sum("ap"), Output: 5
  */

class MapSum {

    class TrieNode {
        boolean isEnd;
        int val;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
        curr.val = val;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return dfs(curr);
    }

    private int dfs(TrieNode root) {
        if (root == null) return 0;

        int res = 0;
        if (root.isEnd) {
            res += root.val;
        }
        for (TrieNode child : root.children) {
            if (child != null) {
                res += dfs(child);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
