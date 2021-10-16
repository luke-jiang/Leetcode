// [UnionFind]

/** You are given a list of equivalent string pairs synonyms where synonyms[i] = [si, ti] indicates that si and ti are equivalent strings. 
  * You are also given a sentence text.
  *
  * Return all possible synonymous sentences sorted lexicographically.
  *
  * Example 1:
  * Input:
  * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
  * text = "I am happy today but was sad yesterday"
  * Output:
      ["I am cheerful today but was sad yesterday",
      "I am cheerful today but was sorrow yesterday",
      "I am happy today but was sad yesterday",
      "I am happy today but was sorrow yesterday",
      "I am joy today but was sad yesterday",
      "I am joy today but was sorrow yesterday"]
  
  * Example 2:
  * Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy today but was sad yesterday"
  * Output: ["I am happy today but was sad yesterday","I am joy today but was sad yesterday"]

  * Example 3:
  * Input: synonyms = [["a","b"],["c","d"],["e","f"]], text = "a c e"
  * Output: ["a c e","a c f","a d e","a d f","b c e","b c f","b d e","b d f"]

  * Example 4:
  * Input: synonyms = [["a","QrbCl"]], text = "d QrbCl ya ya NjZQ"
  * Output: ["d QrbCl ya ya NjZQ","d a ya ya NjZQ"]

  * Constraints:
    0 <= synonyms.length <= 10
    synonyms[i].length == 2
    1 <= si.length, ti.length <= 10
    si != ti
    text consists of at most 10 words.
    The words of text are separated by single spaces.
 */

class Solution {
    public class UnionFind {
        int[] parent;
        public UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    
    Map<String, Integer> word2Index;
    UnionFind uf;
    Map<Integer, List<String>> index2Words;
    List<String> res;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        word2Index = new HashMap<>();
        uf = new UnionFind(synonyms.size() * 2);
        int index = 0;
        for (List<String> pair : synonyms) {
            for (String w : pair) {
                if (!word2Index.containsKey(w)) {
                    word2Index.put(w, index);
                    index++;
                }
            }
            uf.union(word2Index.get(pair.get(0)), word2Index.get(pair.get(1)));
        }
        // System.out.println(word2Index);
        // System.out.println(Arrays.toString(uf.parent));
        
        index2Words = new HashMap<>();
        for (String word : word2Index.keySet()) {
            int i = uf.find(word2Index.get(word));
            List<String> ls = index2Words.getOrDefault(i, new ArrayList());
            ls.add(word);
            index2Words.put(i, ls);
        }
        for (Integer i : index2Words.keySet()) {
            Collections.sort(index2Words.get(i));
        }
        // System.out.println(index2Words);
        
        String[] words = text.split(" ");
        res = new ArrayList<>();
        dfs(words, new String[words.length], 0);
        return res;
    }
    
    private void dfs(String[] words, String[] curr, int i) {
        if (i >= words.length) {
            res.add(String.join(" ", curr));
            return;
        }
        String word = words[i];
        if (!word2Index.containsKey(word)) {
            curr[i] = word;
            dfs(words, curr, i+1);
        } else {
            int index = uf.find(word2Index.get(word));
            List<String> synonyms = index2Words.get(index);
            for (String nym : synonyms) {
                curr[i] = nym;
                dfs(words, curr, i+1);
            }
        }
    }
}
