class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topoOrder = new int[numCourses];


        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            List<Integer> ls = graph.getOrDefault(from, new ArrayList<>());
            ls.add(to);
            graph.put(from, ls);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topoOrder[index] = node;
            index++;

            if (graph.containsKey(node)) {
                for (Integer neighbor : graph.get(node)) {
                    indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (index == numCourses) {
            return topoOrder;
        }
        return new int[0];
    }
}
