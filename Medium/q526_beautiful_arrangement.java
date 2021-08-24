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
