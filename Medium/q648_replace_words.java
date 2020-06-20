// [Trie]

/** In English, we have a concept called root, which can be followed by some other words
  * to form another longer word - let's call this word successor. For example, the root an,
  * followed by other, which can form another word another.
  * Now, given a dictionary consisting of many roots and a sentence. You need to replace all
  * the successor in the sentence with the root forming it. If a successor has many roots can
  * form it, replace it with the root with the shortest length.
  * You need to output the sentence after the replacement.
  *
  * Example 1:
  * Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
  * Output: "the cat was rat by the bat"
  *
  * Constraints:
  * The input will only have lower-case letters.
  * 1 <= dict.length <= 1000
  * 1 <= dict[i].length <= 100
  * 1 <= sentence words number <= 1000
  * 1 <= sentence words length <= 1000
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

        public Trie(List<String> words) {
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

        public String search(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    return word;
                }
                curr = curr.children[index];
                if (curr == null) return word;
                else if (curr.isEnd) return curr.val;
            }
            return word;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie(dict);
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = trie.search(words[i]);
        }

        return String.join(" ", words);
    }
}
