// [Graph, DFS, Tarjan's Algorithm]

/** There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
  * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
  * Any server can reach any other server directly or indirectly through the network.
  *
  * A critical connection is a connection that, if removed, will make some server unable to reach
  * some other server.
  *
  * Return all critical connections in the network in any order.
  */

// TARJAN'S ALGORITHM
// use a timestamp to keep track of the order that nodes are visited.
// when encounter a node u, for all its neighbors v, find the smallest timestamp.
// If this timestamp is smaller than u's timestamp, then some children of u is visited
// before, which means a cycle is present and edge(parent, u) cannot be a critical edge.

class Solution {
    List<Integer>[] graph;
    List<List<Integer>> res;
    int T;
    int timestamp[];
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        // System.out.println(Arrays.toString(graph));
        res = new ArrayList<>();
        T = 1;
        timestamp = new int[n];
        
        dfs(-1, 0);
        
        return res;
    }
    
    private int dfs(int parent, int curr) {
        if (timestamp[curr] != 0) return timestamp[curr];
        timestamp[curr] = T++;
        
        int min = Integer.MAX_VALUE;
        for (int neighbor : graph[curr]) {
            if (neighbor == parent) continue;
            min = Math.min(min, dfs(curr, neighbor));
        }
        
        if (min >= timestamp[curr] && parent != -1) {
            res.add(Arrays.asList(parent, curr));
        }
        
        return Math.min(min, timestamp[curr]);
    }
}

class Solution {
    List<Integer>[] graph;      // adjacency list representation of the graph
    int T;                      // time counter, which gives the current timestamp.
    List<List<Integer>> res;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // build a graph representation
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        T = 1;
        res = new ArrayList<>();
        int[] timestamps = new int[n];

        dfs(-1, 0, timestamps);

        return res;
    }

    private int dfs(int parent, int node, int[] timestamps) {
        if (timestamps[node] != 0) {
            return timestamps[node];
        }
        timestamps[node] = T++;
        // int currentStamp = timestamps[node];

        int minStamp = Integer.MAX_VALUE;
        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue; // skip the parent

            int neighborStamp = dfs(node, neighbor, timestamps);
            minStamp = Math.min(minStamp, neighborStamp);
        }

        if (minStamp >= timestamps[node]) {
            if (parent > -1) {
                res.add(Arrays.asList(parent, node));
            }
        }

        return Math.min(timestamps[node], minStamp);
    }
}
