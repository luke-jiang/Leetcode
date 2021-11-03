class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
        Map<String, List<String>> graph = new HashMap<>();
        Map<Pair<String, String>, Double> edges = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> edge = equations.get(i);
            String a = edge.get(0);
            String b = edge.get(1);
            double x = values[i];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);
            edges.put(new Pair(a, b), x);
            edges.put(new Pair(b, a), 1 / x);
        }
        // System.out.println(graph);
        // System.out.println(edges);
        
        // Symbol |-> (component, value)
        // symbols belong to different components are invalid (eval to -1)
        // performs dfs for each component, the starting node is assigned to 1.0
        Map<String, Pair<Integer, Double>> map = new HashMap<>();
        int component = 0;
        for (String init : graph.keySet()) {
            if (map.containsKey(init)) continue;
            component++;
            Stack<String> st = new Stack<>();
            st.push(init);
            map.put(init, new Pair(component, 1.0));
            while (!st.isEmpty()) {
                String node = st.pop();
                double v0 = map.get(node).getValue();
                for (String n : graph.get(node)) {
                    if (map.containsKey(n)) continue;
                    double v = edges.get(new Pair(node, n));
                    map.put(n, new Pair(component, v * v0));
                    st.push(n);
                }
            }
        }
        
        // System.out.println(map);
        double[] res = new double[queries.size()];
        
        // evaluate queries
        int curr = 0;
        for (List<String> q : queries) {
            String x = q.get(0);
            String y = q.get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) {
                res[curr] = -1;
            } else {
                Pair<Integer, Double> p1 = map.get(x);
                Pair<Integer, Double> p2 = map.get(y);
                if (p1.getKey() != p2.getKey()) {
                    res[curr] = -1;
                } else {
                    res[curr] = p2.getValue() / p1.getValue();
                }
            }
            curr++;
        }
        
        return res;
    }
}
