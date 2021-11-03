class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Map<Integer, Integer> seen = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        seen.put(0, -1);
        st.push(0);
        while (!st.isEmpty()) {
            int node = st.pop();
            for (int neighbor : graph[node]) {
                if (seen.get(node) == neighbor) continue;
                if (seen.containsKey(neighbor)) return false;
                seen.put(neighbor, node);
                st.push(neighbor);
            }
        }
        
        return seen.size() == n;
    }
}
