class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += dist(points[i], points[i+1]);
        }
        return sum;
    }
    
    private int dist(int[] x, int[] y) {
        int a = x[0];
        int b = x[1];
        int c = y[0];
        int d = y[1];
        int delt1 = Math.abs(d - b);
        int delt2 = Math.abs(c - a);
        return Math.max(delt1, delt2);
    }
}
