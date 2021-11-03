// [BFS]

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // 0 -> forward
        // 1 -> backward
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        for (int n : forbidden) {
            seen.add(new Pair(0, n));
            seen.add(new Pair(1, n));
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        seen.add(new Pair(0, 0));
        int res = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Pair<Integer, Integer> p = q.remove();
                int direction = p.getKey();
                int position = p.getValue();
                if (position == x) return res;
                Pair<Integer, Integer> p1 = new Pair(0, position + a);
                if (!seen.contains(p1) && position + a < 10000) {
                    q.add(p1); seen.add(p1);
                }
                Pair<Integer, Integer> p2 = new Pair(1, position - b);
                if (!seen.contains(p2) && direction == 0 && position - b > 0) {
                    q.add(p2); seen.add(p2);
                }
            }
            res++;
        }
        return -1;
    }
}
