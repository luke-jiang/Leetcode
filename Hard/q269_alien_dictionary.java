// [Topological Sort]
class Solution {
    Map<Character, Set<Character>> graph;
    Map<Character, Integer> indegree;

    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        indegree = new HashMap<>();
        // initialize maps
        for (String w : words) {
            for (char c : w.toCharArray()) {
                indegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }
        // construct the graph and indegree maps
        for (int i = 0; i < words.length - 1; i++) {
           if (!addEdge(words[i], words[i+1])) return "";
        }
        // System.out.println(graph);
        // System.out.println(indegree);
        StringBuilder sb = new StringBuilder();
        while (indegree.size() > 0) {
            // find all nodes that have zero indegree
            Set<Character> zeros = new HashSet<>();
            for (char c : indegree.keySet()) {
                if (indegree.get(c) == 0) zeros.add(c);
            }
            if (zeros.size() == 0) return "";
            for (char c : zeros) {
                // System.out.println(c);
                indegree.remove(c);
                sb.append(c);
                if (graph.containsKey(c)) {
                    // decrease indegrees for children of the node to be removed
                    for (char child : graph.get(c)) {
                        indegree.put(child, indegree.get(child) - 1);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private boolean addEdge(String x, String y) {
        if (x.length() > y.length() && x.startsWith(y)) return false;
        for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
            char cx = x.charAt(i);
            char cy = y.charAt(i);
            if (cx != cy) {
                if (!graph.get(cx).contains(cy)) {
                    graph.get(cx).add(cy);
                    indegree.put(cy, indegree.get(cy) + 1);
                }
                return true;
            }
        }
        return true;
    }
}
