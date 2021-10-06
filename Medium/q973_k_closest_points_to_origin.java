class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (i, j) -> i[0] * i[0] + i[1] * i[1] - j[0] * j[0] - j[1] * j[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
}
