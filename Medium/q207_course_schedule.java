// [Graph DFS]
class Solution {
    Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        // System.out.println(graph);
        Set<Integer> seen = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (cycle(i, seen, path)) return false;
        }
        return true;
    }
    
    private boolean cycle(int node, Set<Integer> seen, Set<Integer> path) {
        if (seen.contains(node)) return false;
        if (path.contains(node)) return true;
        path.add(node);
        
        boolean res = false;
        for (int child : graph.get(node)) {
            if (cycle(child, seen, path)) {
                res = true; break;
            }
        }
        
        path.remove(node);
        seen.add(node);
        return res;
    }
}
