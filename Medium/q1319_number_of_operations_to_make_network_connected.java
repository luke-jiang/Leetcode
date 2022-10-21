class Solution {
    class UnionFind {
        int count = 0;
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
        
        public boolean union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return false;
            if (rank[rq] > rank[rp]) {
                parent[rp] = rq;
            } else if (rank[rq] < rank[rp]) {
                parent[rq] = rp;
            } else {
                parent[rq] = rp;
                rank[rq]++;
            }
            count--;
            return true;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int extra = 0;
        for (int[] edge : connections) {
            int x = edge[0];
            int y = edge[1];
            if (!uf.union(x, y)) extra++;
        }
        // System.out.println("extra: " + extra);
        // System.out.println("meshes: " + uf.count);
        return extra - (uf.count - 1) >= 0 ? (uf.count - 1) : -1;
    }
}
