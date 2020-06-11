class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("\\W+");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String str : banned) set.add(str);

        int max_count = -1;
        String res = "";
        for (String word : words) {
            if (set.contains(word)) continue;
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            int f = map.get(word);
            map.put(word, f+1);
            if (f+1 > max_count) {
                max_count = f+1;
                res = word;
            }
        }

        return res;
    }
}
