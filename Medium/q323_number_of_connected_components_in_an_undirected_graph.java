// [Graph DFS]
class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            Stack<Integer> st = new Stack<>();
            st.push(i);
            seen[i] = true;
            res++;
            while (!st.isEmpty()) {
                int node = st.pop();
                for (int neighbor : graph[node]) {
                    if (seen[neighbor]) continue;
                    st.push(neighbor);
                    seen[neighbor] = true;
                }
            }
        }
        return res;
    }
}
