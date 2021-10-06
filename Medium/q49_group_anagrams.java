// [HashMap]

/** Given an array of strings, group anagrams together.
  * Example:
  * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  * Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
  * Note:
  * All inputs will be in lowercase.
  * The order of your output does not matter.
  */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String hash = hash(s);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
    
    private String hash(String s) {
        char[] freq = new char[26];
        Arrays.fill(freq, '0');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        return String.valueOf(freq);
    }
}
