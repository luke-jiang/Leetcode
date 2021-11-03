class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // System.out.println(hash("dfa"));
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String h = hash(s);
            map.putIfAbsent(h, new ArrayList<>());
            map.get(h).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
    
    private String hash(String s) {
        StringBuilder sb = new StringBuilder();
        int dist = s.charAt(0) - 'a';
        // System.out.println(dist);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(0)) {
                sb.append((char) (s.charAt(i) - dist + 26));
            } else {
                sb.append((char) (s.charAt(i) - dist));
            }
        }
        return sb.toString();
    }
}
