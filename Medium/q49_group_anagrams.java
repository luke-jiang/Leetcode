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
