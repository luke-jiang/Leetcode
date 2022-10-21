// [DFS, UnionFind]

class Solution {
    boolean[] seen;
    int n;
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        n = isConnected.length;
        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int[][] isConnected, int i) {
        if (seen[i]) return;
        seen[i] = true;
        for (int j = 0; j < n; j++) {
            if (j != i && isConnected[i][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}


class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            if (rank[rp] > rank[rq]) {
                parent[rq] = rp;
            } else if (rank[rp] < rank[rq]) {
                parent[rp] = rq;
            } else {
                parent[rq] = rp;
                rank[rp]++;
            }
            count--;
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind ds = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    ds.union(i, j);
                }
            }
        }
        return ds.count;
    }
}
