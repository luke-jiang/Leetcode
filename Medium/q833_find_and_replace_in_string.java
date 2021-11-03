class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String> src = new HashMap<>();
        Map<Integer, String> trg = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            src.put(indices[i], sources[i]);
            trg.put(indices[i], targets[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!src.containsKey(i)) {
                sb.append(s.charAt(i));
            } else {
                String pattern = src.get(i);
                if (s.substring(i).startsWith(pattern)) {
                    sb.append(trg.get(i));
                    i += pattern.length() - 1;
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
