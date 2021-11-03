// [DFS]

class Solution {
    Map<String, List<String>> graph;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        res = new ArrayList<>();
        // construct the graph
        for (List<String> edge : tickets) {
            String x = edge.get(0);
            String y = edge.get(1);
            graph.putIfAbsent(x, new LinkedList<>());
            graph.get(x).add(y);
        }
        // sort destinations alphabetically
        graph.forEach((s, d) -> Collections.sort(d));
        // dfs
        dfs("JFK");
        return res;
    }
    
    // post-order dfs
    private void dfs(String origin) {
        // res.add(origin);
        if (graph.containsKey(origin)) {
            List<String> neighbors = graph.get(origin);
            while (!neighbors.isEmpty()) {
                String next = neighbors.remove(0);
                dfs(next);
            }
        }
        res.add(0, origin);
    }
}
