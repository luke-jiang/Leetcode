class Solution {
    // [m,k] * [k,n]
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;
        
        // reduce mat1 to a map
        Map<Integer, Set<Integer>> m1 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (mat1[i][j] == 0) continue;
                Set row = m1.getOrDefault(i, new HashSet<>());
                row.add(j);
                m1.put(i, row);
            }
        }
        
        // reduce mat2 to a map
        Map<Integer, Set<Integer>> m2 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (mat2[i][j] == 0) continue;
                Set col = m2.getOrDefault(j, new HashSet<>());
                col.add(i);
                m2.put(j, col);
            }
        }
        
        int[][] res = new int[m][n];
        for (int i : m1.keySet()) {
            for (int j : m2.keySet()) {
                Set<Integer> s = new HashSet<>(m1.get(i));
                s.retainAll(m2.get(j));
                for (int h : s) {
                    res[i][j] += mat1[i][h] * mat2[h][j];
                    // System.out.println(res[i][j]);
                }
            }
        }
        
        return res;
    }
}
