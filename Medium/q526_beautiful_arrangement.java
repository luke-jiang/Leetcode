// [Backtracking]

class Solution {
    int count = 0;

    public int countArrangement(int N) {
        boolean[] seen = new boolean[N+1];
        backtrack(N, 1, seen);
        return count;
    }

    private void backtrack(int N, int index, boolean[] seen) {
        if (index > N) {
            count++;
        }
        for (int i = 1; i <= N; i++) {
            if (!seen[i] && (index % i == 0 || i % index == 0)) {
                seen[i] = true;
                backtrack(N, index + 1, seen);
                seen[i] = false;
            }
        }
    }
}

class Solution {
    int res;
    
    public int countArrangement(int n) {
        res = 0;
        List<Integer> candidates = new LinkedList<>();
        for (int i = 1; i <= n; i++) candidates.add(i);
        backtrack(1, candidates);
        return res;
    }
    
    private void backtrack(int i, List<Integer> candidates) {
        if (candidates.isEmpty()) res++;
        for (int j = 0; j < candidates.size(); j++) {
            int n = candidates.get(j);
            if (n % i == 0 || i % n == 0) {
                candidates.remove(j);
                backtrack(i+1, candidates);
                candidates.add(j, n);
            }
        }
    }
}
