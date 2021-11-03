// [Geometry]

class Solution {
    int shorter = Integer.MAX_VALUE;
    int longer = 0;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> dist = new HashSet<>();
        dist.add(dist(p1, p2));
        dist.add(dist(p1, p3));
        dist.add(dist(p1, p4));
        dist.add(dist(p2, p3));
        dist.add(dist(p2, p4));
        dist.add(dist(p3, p4));
        if (dist.size() != 2) return false;
        // System.out.println(shorter);
        // System.out.println(longer);
        return shorter != Integer.MAX_VALUE && longer != 0 && shorter * 2 == longer;
    }
    private int dist(int[] a, int[] b) {
        int dy = b[1] - a[1];
        int dx = b[0] - a[0];
        int dist = dx * dx + dy * dy;
        shorter = Math.min(shorter, dist);
        longer = Math.max(longer, dist);
        return dist;
    }
}
}
