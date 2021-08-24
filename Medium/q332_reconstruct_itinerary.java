// [Graoh DFS]

class Solution {
    List<String> res;
    Map<String, PriorityQueue<String>> graph;

    public List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        graph = new HashMap<>();

        for (List<String> t: tickets) {
            String from = t.get(0);
            String to = t.get(1);
            graph.putIfAbsent(from, new PriorityQueue<String>());
            graph.get(from).add(to);
        }

        search("JFK");
        return res;
    }

    public void search(String curr) {
        PriorityQueue<String> dest_list = graph.get(curr);
        while (dest_list != null && !dest_list.isEmpty()) {
            search(dest_list.remove());
        }
        res.add(0, curr);
    }
}
