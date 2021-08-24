class Solution {
    // prefix -> ways of splittings
    Map<String, List<String>> map;
    Set<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        map.put("", new ArrayList<>());
        map.get("").add("");
        set = new HashSet<>(wordDict);
        return dfs(s);
    }

    private List<String> dfs(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> sentences = new ArrayList<>();

        for (String str : set) {
            if (!s.startsWith(str)) continue;
            String suffix = s.substring(str.length());

            for (String tail : dfs(suffix)) {
                if (tail.length() == 0) {
                    sentences.add(str);
                } else {
                    sentences.add(str + " " + tail);
                }
            }
        }

        map.put(s, sentences);
        return sentences;
    }
}
