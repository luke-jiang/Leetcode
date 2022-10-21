class Solution {
    class UnionFind {
        int[] parent, rank, count;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public void insert(int p) {
            if (p < 0 || p >= count.length) return;
            count[p] = 1;
        }
        public int find(int p) {
            if (p < 0 || p >= count.length || count[p] == 0) return -1;
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq || rp == -1 || rq == -1) return;
            if (rank[rp] > rank[rq]) {
                parent[rq] = rp;
                count[rp] += count[rq];
            } else if (rank[rp] < rank[rq]) {
                parent[rp] = rq;
                count[rq] += count[rp];
            } else {
                parent[rq] = rp;
                count[rp] += count[rq];
                rank[rp]++;
            }
        }
        private int maxCount() {
            int res = 0;
            for (int n : count) res = Math.max(res, n);
            return res;
        }
    }

    // Use Union Find
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // `map` maps nums[i] to range (0, nums.length)
        // reduce input space of UnionFind
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, map.size());
            }
        }
        
        UnionFind uf = new UnionFind(map.size());
        for (int n : nums) {
            int v = map.get(n);
            if (uf.count[v] == 0) {
                uf.insert(v);
                // try union the previous and next elements with map
                uf.union(v, map.getOrDefault(n-1, -1));
                uf.union(v, map.getOrDefault(n+1, -1));
            }
            
        }
        // System.out.println(Arrays.toString(uf.count));
        return uf.maxCount();
    }
}
